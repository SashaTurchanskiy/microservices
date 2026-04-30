package com.zosh.payload.response;


import com.zosh.enums.AirlineStatus;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftResponse {

    private Long id;
    private String code;
    private String model;
    private String manufacturer;
    private Integer seatingCapacity;
    private Integer economySeats;
    private Integer premiumEconomySeats;
    private Integer businessSeats;
    private Integer firstClassSeats;
    private Integer rangeKms;
    private Integer cruisingSpeedKhm;
    private Integer maxAltitudeFeet;
    private Integer yearOfManufacture;
    private LocalDate registrationDate; // ISO format: YYYY-MM-DD
    private LocalDate nextMaintenanceDate; // ISO format: YYYY-MM-DD
    private AirlineStatus status;
    private Boolean isAvailable;

    private Long airlineId;
    private String airlineName;
    private String airlineIataCode;

    private Long currentAirportId;
    private Long currentAirportCity;
    private String currentAirportCode;
    private String currentAirportName;

    private Integer totalSeats;
    private Boolean requiresMaintenance;
    private Boolean isOperational;

    private Instant createdAt;
    private Instant updatedAt;
}
