package com.kitsune.kitsune_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="solicitud_ride")
@Data
public class SolicitudRide{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="solicitud_id")
    private int solicitudId;

    @Column(name="ride_id")
    private int rideId;

    @Column(name="conductor_id")
    private int conductorId;
}