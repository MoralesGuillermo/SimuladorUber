package com.kitsune.kitsune_api.services.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.MetodosPago;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.repositories.ClienteRepository;
import com.kitsune.kitsune_api.repositories.MetodosPagoRepository;
import com.kitsune.kitsune_api.repositories.TarjetasRepository;
import com.kitsune.kitsune_api.services.TarjetasService;

@Service
public class TarjetasServiceImpl implements TarjetasService{

    @Autowired
    private TarjetasRepository tarjetasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired 
    private MetodosPagoRepository metodosPagoRepository;

    @Override
    public HttpResponse<TarjetasDTO> nuevaTarjeta(Tarjetas tarjeta, int clienteId) {
        HttpResponse<TarjetasDTO> response = new HttpResponse<>();

        //Si existe el cliente
        if(this.clienteRepository.existsById(clienteId)){
            //La tarjeta que ya tiene el id
           
            //Lo comentado es otra version
            
            Cliente clienteGuardar = this.clienteRepository.findById(clienteId).get();
            tarjeta.setCliente(clienteGuardar);
            List<MetodosPago> metodosPagoGuardar = tarjeta.getMetodospago();
            
            for (MetodosPago metodosPago2 : metodosPagoGuardar) {
                metodosPago2.setTarjetas(tarjeta);
                metodosPagoRepository.save(metodosPago2);
            }


            Tarjetas tarjetaGuardada = this.tarjetasRepository.save(tarjeta);
            
              
            List<Tarjetas> tarjetasGuardar = clienteGuardar.getTarjetas();
            tarjetasGuardar.add(tarjetaGuardada);
            clienteGuardar.setTarjetas(tarjetasGuardar);
            this.clienteRepository.save(clienteGuardar);
            List<MetodosPago> listaMetodosPagos = metodosPagoRepository.findAllByTarjetas(tarjetaGuardada);
            List<Character> metodoCharacters = new ArrayList<>();

            TarjetasDTO tarjetasDTO = new TarjetasDTO();
            tarjetasDTO.setCvv(tarjetaGuardada.getCvv());
            tarjetasDTO.setFechaCaducidad(tarjetaGuardada.getFechaCaducidad());
            tarjetasDTO.setPan(tarjetaGuardada.getPan());
            tarjetasDTO.setUsername(tarjetaGuardada.getCliente().getUsuario().getUsername());

            for (MetodosPago metodosPago : listaMetodosPagos) {
                metodoCharacters.add((Character) metodosPago.getTipoMetodo());
            }
            tarjetasDTO.setMetodosDePago(metodoCharacters);

            response.setResponseBody(tarjetasDTO);
            response.setStatus((short)200);
            return response;
        }
        //Si No existe el cliente
        else{
            response.setStatus((short)400);
            return response;
        }

    }

    @Override
    public HttpResponse<String> eliminarTarjeta(String pan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarTarjeta'");
    }
    
}
