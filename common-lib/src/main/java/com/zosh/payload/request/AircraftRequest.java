package com.zosh.payload.request;

import com.zosh.enums.AirlineStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftRequest {

    @NotBlank(message = "Aircraft code is required")
    private String code;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @NotNull(message = "Seating capacity is required")
    @Positive(message = "Seating capacity must be a positive integer")
    private Integer seatingCapacity;

    @Positive(message = "Economy seats must be a positive integer")
    private Integer economySeats;

    @Positive(message = "Premium economy seats must be a positive integer")
    private Integer premiumEconomySeats;

    @NotNull(message = "Business seats are required")
    @Positive(message = "Business seats must be a positive integer")
    private Integer businessSeats;

    @Positive(message = "First class seats must be a positive integer")
    private Integer firstClassSeats;

    @Positive(message = "Range in kilometers must be a positive integer")
    private Integer rangeKms;

    @Positive(message = "Cruising speed must be a positive integer")
    private Integer cruisingSpeedKhm;

    @Positive(message = "Maximum altitude must be a positive integer")
    private Integer maxAltitudeFeet;

    @Positive(message = "Year of manufacture must be a positive integer")
    private Integer yearOfManufacture;

    private LocalDate registrationDate; // ISO format: YYYY-MM-DD
    private LocalDate nextMaintenanceDate; // ISO format: YYYY-MM-DD

    @NotNull(message = "Status is required")
    private AirlineStatus status;

    @NotNull(message = "Availability status is required")
    private Boolean isAvailable;

    private Long currentAirportId;


}
