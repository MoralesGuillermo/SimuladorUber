package com.kitsune.kitsune_api.services.impl;

import java.sql.Driver;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitsune.kitsune_api.dto.HttpResponse;
import com.kitsune.kitsune_api.dto.RideDto;
import com.kitsune.kitsune_api.entities.Cliente;
import com.kitsune.kitsune_api.entities.Conductor;
import com.kitsune.kitsune_api.entities.Direcciones;
import com.kitsune.kitsune_api.entities.Parametros;
import com.kitsune.kitsune_api.entities.Rides;
import com.kitsune.kitsune_api.entities.SolicitarRide;
import com.kitsune.kitsune_api.repositories.ClienteRepository;
import com.kitsune.kitsune_api.repositories.ConductorRepository;
import com.kitsune.kitsune_api.repositories.DireccionesRepository;
import com.kitsune.kitsune_api.repositories.MetodosPagoRepository;
import com.kitsune.kitsune_api.repositories.ParametrosRepository;
import com.kitsune.kitsune_api.repositories.RidesRepository;
import com.kitsune.kitsune_api.repositories.SolicitudRideRepository;
import com.kitsune.kitsune_api.services.RidesService;

@Service
public class RidesServiceImpl implements RidesService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RidesRepository ridesRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private DireccionesRepository direccionesRepository;

    @Autowired
    private MetodosPagoRepository metodosPagoRepository;

    @Autowired
    private ParametrosRepository parametrosRepository;

    @Autowired
    private SolicitudRideRepository solicitudRideRepository;

    @Override
    public HttpResponse<RideDto> solicitarRide(RideDto ride) {
        HttpResponse<RideDto> response = new HttpResponse<>();
        if (solicitudrideIncompleto(ride)){
            response.setStatus((short) 400);
            return response;
        }
        if(this.clienteRepository.existsById(ride.getClienteid())){
            Cliente clienteRide = this.clienteRepository.findById(ride.getClienteid()).get();
                Rides nvoRide = new Rides();
                nvoRide.setCliente(clienteRide);
                nvoRide.setCosto(ride.getCosto());
                nvoRide.setEstatus('P');
                nvoRide.setDireccionOrigen(ride.getOrigen());
                nvoRide.setDireccionDestino(ride.getDestino());
                nvoRide.setDistancia(ride.getDistancia());
                nvoRide.setFecha(LocalDate.now());
                Rides svdRide = ridesRepository.save(nvoRide);
                ride.setRideId(svdRide.getRideId());
                askRiders(svdRide.getRideId());

                response.setStatus((short) 200);
                response.setResponseBody(ride);
                return response;
        }
        response.setStatus((short) 404);
        return response;
    }

    private boolean solicitudrideIncompleto(RideDto ride){
        return (ride == null || ride.getClienteid() == 0);
    } 

    private void askRiders(int rideId){
        List<Conductor> conductores = (List<Conductor>) this.conductorRepository.findAll();
        for (Conductor conductor: conductores){
            SolicitarRide solicitud = new SolicitarRide();
            solicitud.setRideId(rideId);
            solicitud.setConductorId(conductor.getConductorId());
            solicitudRideRepository.save(solicitud);
        }
    }



    @Override
    public HttpResponse<Rides> nuevoRide(RideDto ride) {
        HttpResponse<Rides> response = new HttpResponse<>();
        if (rideIncompleto(ride)){
            response.setStatus((short)400);
            return response;
        }

        if(this.clienteRepository.existsById(ride.getClienteid()) && this.conductorRepository.existsById(ride.getConductorId())){
        Rides nuevoRide = new Rides();
        Conductor conductor = conductorRepository.findById(ride.getConductorId()).get();
        nuevoRide.setDistancia(ride.getDistancia());
        nuevoRide.setCosto(ride.getCosto());
        nuevoRide.setEstatus('A'); //El estatus del ride es aprobado
        nuevoRide.setCliente(this.clienteRepository.findById(ride.getClienteid()).get());
        nuevoRide.setConductor(conductor);
        conductor.setDisponible(false); //El conductor deja de estar disponible
        //nuevoRide.setDireccionOrigen(this.direccionesRepository.findById(ride.getIdDireccionOrigen()).get());
        //nuevoRide.setDireccionDestino(this.direccionesRepository.findById(ride.getIdDireccionDestino()).get());
        //nuevoRide.setMetodospago(this.metodosPagoRepository.findById(ride.getMetodoid()).get());
        nuevoRide.setCliente(this.clienteRepository.findById(ride.getClienteid()).get());
        this.conductorRepository.save(conductor);
         Rides rideIniciado = this.ridesRepository.save(nuevoRide);
            response.setStatus((short) 200);
            response.setResponseBody(rideIniciado);
            return response;
        }    
        response.setStatus((short) 404);
        return response;
    }

    private boolean rideIncompleto(RideDto ride){
        return (ride == null || ride.getClienteid()== 0 || ride.getConductorId()== 0);
    } 


    @Override
    public HttpResponse<String> cancelarRide(int rideId) {
        HttpResponse<String> response = new HttpResponse<>();
            if (this.ridesRepository.existsById(rideId)) {
                Rides rideCancelado = this.ridesRepository.findById(rideId).get();
                rideCancelado.setEstatus('C');
                this.ridesRepository.save(rideCancelado);
                response.setStatus((short) 200);
                response.setResponseBody("Ride Cancelado Correctamente");
                return response;
            }
            response.setStatus((short) 404);
            return response;
        }


    @Override
    public HttpResponse<String> calificarRide(int rideId, int calificacion) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.ridesRepository.existsById(rideId)) {
            Rides rideCalificar = this.ridesRepository.findById(rideId).get();
            Conductor conductorCalificado = this.conductorRepository.findById(rideCalificar.getConductor().getConductorId()).get();
            rideCalificar.setCalificacion(calificacion);
            this.ridesRepository.save(rideCalificar);
            if(conductorCalificado.getRating()==0){
            conductorCalificado.setRating(calificacion);  
          
            } else { //CalcularNuevoRating
            Double ratingActual=conductorCalificado.getRating();
            List<Rides> RidesRealizados = conductorCalificado.getRides();
            int CantidadRides = RidesRealizados.size();
            conductorCalificado.setRating((ratingActual+calificacion)/(CantidadRides+1)); 
        }
        this.conductorRepository.save(conductorCalificado);  
            response.setStatus((short) 200);
            response.setResponseBody("Ride Calificado Correctamente");
            return response;
        }
        response.setStatus((short) 404);
        return response;
    }

    @Override
    public HttpResponse<String> finalizarRide(int rideId) {
        HttpResponse<String> response = new HttpResponse<>();
        if (this.ridesRepository.existsById(rideId)) {
            Rides rideFinalizado = this.ridesRepository.findById(rideId).get();
            rideFinalizado.setEstatus('F');
            Conductor conductorRide= this.conductorRepository.findById(rideFinalizado.getConductor().getConductorId()).get();
            conductorRide.setDisponible(true);
            this.conductorRepository.save(conductorRide);
            this.ridesRepository.save(rideFinalizado);
            response.setStatus((short) 200);
            response.setResponseBody("Ride Finalizado Correctamente");
            return response;
        }
        response.setStatus((short) 404);
        return response;
    }

    @Override
    public HttpResponse<Double> solicitarPrecio(float distancia) {
        Double precio;
        double precioNoRound;
        HttpResponse<Double> response = new HttpResponse<>();
        Parametros tarifaBaseParam = this.parametrosRepository.getByDescripcion("TARIFA_BASE");
        double tarifaBase = tarifaBaseParam.getValor();
        precioNoRound = calcularPrecio(distancia, tarifaBase);
        precio = round(precioNoRound);
        response.setStatus((short)200);
        response.setResponseBody(precio);
        return response;    
    }


    private double calcularPrecio(float distancia, double tarifaBase){
        double precio;
        if (distancia <= 1.0){
            precio =   tarifaBase; 
        }else{
            precio =  tarifaBase*distancia;
        }
        return precio;
    }

    private Double round(double nonRoundedValue){
        DecimalFormat df = new DecimalFormat("####.##");
        String rounderNumerString = df.format(nonRoundedValue);
        return Double.parseDouble(rounderNumerString);
    }

    @Override
    public HttpResponse<Boolean> fueAceptado(int rideId) {
        Rides ride = this.ridesRepository.findById(rideId).get();
        HttpResponse<Boolean> response = new HttpResponse<>();
        if (ride.getEstatus() == 'A'){
            response.setStatus((short) 200);
            response.setResponseBody(true);
            return response;
        }
        response.setStatus((short) 400);
        return response;
    } 
}
