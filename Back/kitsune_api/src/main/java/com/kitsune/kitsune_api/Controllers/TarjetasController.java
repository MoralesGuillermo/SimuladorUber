package com.kitsune.kitsune_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.TarjetasDTO;
import com.kitsune.kitsune_api.entities.Tarjetas;
import com.kitsune.kitsune_api.services.impl.TarjetasServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/kitsune/tarjeta")
public class TarjetasController {

    @Autowired
    private TarjetasServiceImpl tarjetasServiceImpl;
    

    @PostMapping("/crear")
    public HttpResponse<TarjetasDTO> crearTarjeta(@RequestBody TarjetasDTO tarjetasDTO) {
        return this.tarjetasServiceImpl.nuevaTarjeta(tarjetasDTO);
    }

    @DeleteMapping("/eliminarTarjeta/{pan}")
    public HttpResponse<String> eliminarTarjeta(@PathVariable String pan){
        return this.tarjetasServiceImpl.eliminarTarjeta(pan);
    }

    @GetMapping("/idClienteObtener/{username}")
    public HttpResponse<Integer> clienteIdObtener(@PathVariable String username) {
        return this.tarjetasServiceImpl.obtenerIdCliente(username);
    }
    
}