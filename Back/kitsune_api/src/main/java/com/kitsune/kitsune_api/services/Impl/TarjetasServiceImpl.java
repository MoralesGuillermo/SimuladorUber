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
import com.kitsune.kitsune_api.entities.Usuario;
import com.kitsune.kitsune_api.repositories.ClienteRepository;
import com.kitsune.kitsune_api.repositories.MetodosPagoRepository;
import com.kitsune.kitsune_api.repositories.TarjetasRepository;
import com.kitsune.kitsune_api.repositories.UsuarioRepository;
import com.kitsune.kitsune_api.services.TarjetasService;

@Service
public class TarjetasServiceImpl implements TarjetasService{

    @Autowired
    private TarjetasRepository tarjetasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired 
    private MetodosPagoRepository metodosPagoRepository;

    @Autowired 
    private UsuarioRepository usuarioRepository;


    public HttpResponse<TarjetasDTO> nuevaTarjeta2(TarjetasDTO tarjetasDTO2) {
        HttpResponse<TarjetasDTO> response = new HttpResponse<>();
        Usuario usuario= this.usuarioRepository.getByUsername(tarjetasDTO2.getUsername());
        Cliente cliente = usuario.getCliente();
        int clienteId = cliente.getClienteId();
     

        Tarjetas tarjeta = new Tarjetas();
        tarjeta.setCvv(tarjetasDTO2.getCvv());
        tarjeta.setFechaCaducidad(tarjetasDTO2.getFechaCaducidad());



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
    public HttpResponse<TarjetasDTO> nuevaTarjeta(TarjetasDTO tarjetasDTO) {
        HttpResponse<TarjetasDTO> response = new HttpResponse<>();
     


        //Si existe el cliente
        if(this.clienteRepository.existsById(this.usuarioRepository.getByUsername(tarjetasDTO.getUsername()).getCliente().getClienteId())){

            Tarjetas tarjetas = new Tarjetas();
            List<MetodosPago> metodosPagos = new ArrayList<>();
            Cliente clienteGuardar = this.usuarioRepository.getByUsername(tarjetasDTO.getUsername()).getCliente();

            //Toma el primero de la lista de metodos pago en la tarjeta y es el unico que guarda
            for (MetodosPago metodosPago : metodosPagos) {
                metodosPago.setTipoMetodo(tarjetasDTO.getMetodosDePago().get(0));
                metodosPago.setTarjetas(tarjetas); 
                metodosPagos.add(metodosPago);
            }

            //Setea la tarjeta que se va a guardar
            tarjetas.setCliente(clienteGuardar);
            tarjetas.setCvv(tarjetasDTO.getCvv());
            tarjetas.setFechaCaducidad(tarjetasDTO.getFechaCaducidad());
            tarjetas.setPan(tarjetasDTO.getPan());
            tarjetas.setMetodospago(metodosPagos);

            //Obtenemos la tarjeta guradada para agregarla al cliente
            Tarjetas tarjetaGuardada = this.tarjetasRepository.save(tarjetas);

            //Guardamos la tarjeta en cliente
            List<Tarjetas> tarjetasGuardar = clienteGuardar.getTarjetas();
            tarjetasGuardar.add(tarjetaGuardada);
            clienteGuardar.setTarjetas(tarjetasGuardar);
            this.clienteRepository.save(clienteGuardar);

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
        HttpResponse<String> response = new HttpResponse<>();
        if (null!=pan) {
            if (this.tarjetasRepository.existsById(pan)) {
                Tarjetas tarjeta = this.tarjetasRepository.findById(pan).get();
                this.tarjetasRepository.delete(tarjeta);
                response.setStatus((short) 200);
                return response;
            }
            response.setStatus((short) 404);
            return response;
        }
        response.setStatus((short) 400);
        return response;
    }
    

    //Se usa para el perfil en el que creas la tarjeta y te devuelve a el perfil del usuario al cual se la creaste
    public HttpResponse<Integer> obtenerIdCliente(String username){
        HttpResponse<Integer> response = new HttpResponse<>();
        response.setResponseBody(this.usuarioRepository.getByUsername(username).getCliente().getClienteId());
            response.setStatus((short)200);
            return response;

            
    }
}
