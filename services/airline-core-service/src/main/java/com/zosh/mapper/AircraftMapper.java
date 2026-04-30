package com.zosh.mapper;

import com.zosh.enums.AircraftStatus;
import com.zosh.enums.AirlineStatus;
import com.zosh.model.Aircraft;
import com.zosh.model.Airline;
import com.zosh.payload.request.AircraftRequest;
import com.zosh.payload.request.AirlineRequest;
import com.zosh.payload.response.AircraftResponse;

public class AircraftMapper {

    public static Aircraft toEntity(AircraftRequest request, Airline airline){
        if (request == null){ return null;}

        return Aircraft.builder()
                .code(request.getCode())
                .model(request.getModel())
                .manufacturer(request.getManufacturer())
                .seatingCapacity(request.getSeatingCapacity())
                .economySeats(request.getEconomySeats())
                .premiumEconomySeats(request.getPremiumEconomySeats())
                .firstClassSeats(request.getFirstClassSeats())
                .rangeKms(request.getRangeKms())
                .cruisingSpeedKhm(request.getCruisingSpeedKhm())
                .maxAltitudeFeet(request.getMaxAltitudeFeet())
                .yearOfManufacture(request.getYearOfManufacture())
                .registrationDate(request.getRegistrationDate())
                .nextMaintenanceDate(request.getNextMaintenanceDate())
                .status(AircraftStatus.ACTIVE) // Default status, can be modified later
                .isAvailable(request.getIsAvailable()) // Default availability, can be modified later
                .airline(airline)
                .currentAirportId(request.getCurrentAirportId())
                .build();
    }

    public static AircraftResponse toResponse(Aircraft aircraft){
        if (aircraft == null){return null;}

        return AircraftResponse.builder()
                .id(aircraft.getId())
                .code(aircraft.getCode())
                .model(aircraft.getModel())
                .manufacturer(aircraft.getManufacturer())
                .seatingCapacity(aircraft.getSeatingCapacity())
                .economySeats(aircraft.getEconomySeats())
                .premiumEconomySeats(aircraft.getPremiumEconomySeats())
                .businessSeats(aircraft.getBusinessSeats())
                .firstClassSeats(aircraft.getFirstClassSeats())
                .rangeKms(aircraft.getRangeKms())
                .cruisingSpeedKhm(aircraft.getCruisingSpeedKhm())
                .maxAltitudeFeet(aircraft.getMaxAltitudeFeet())
                .yearOfManufacture(aircraft.getYearOfManufacture())
                .registrationDate(aircraft.getRegistrationDate())
                .nextMaintenanceDate(aircraft.getNextMaintenanceDate())
                .status(AirlineStatus.ACTIVE)
                .isAvailable(aircraft.getIsAvailable())

                .airlineId(aircraft.getAirline() != null ? aircraft.getAirline().getId() : null)
                .airlineName(aircraft.getAirline() != null ? aircraft.getAirline().getName() : null)
                .airlineIataCode(aircraft.getAirline() != null ? aircraft.getAirline().getIataCode() : null)

                .currentAirportId(aircraft.getCurrentAirportId())
                .requiresMaintenance(aircraft.requiresMaintenance())
                .isOperational(aircraft.isOperational())

                .createdAt(aircraft.getCreatedAt())
                .updatedAt(aircraft.getCreatedAt()) // Assuming updatedAt is not tracked separately in the entity
                .build();
    }

    public static void updateEntity(Aircraft aircraft, AircraftRequest request){
        if (aircraft == null || request == null){ return;}

        aircraft.setCode(request.getCode());
        aircraft.setModel(request.getModel());
        aircraft.setManufacturer(request.getManufacturer());
        aircraft.setSeatingCapacity(request.getSeatingCapacity());
        aircraft.setEconomySeats(request.getEconomySeats());
        aircraft.setPremiumEconomySeats(request.getPremiumEconomySeats());
        aircraft.setFirstClassSeats(request.getFirstClassSeats());
        aircraft.setRangeKms(request.getRangeKms());
        aircraft.setCruisingSpeedKhm(request.getCruisingSpeedKhm());
        aircraft.setMaxAltitudeFeet(request.getMaxAltitudeFeet());
        aircraft.setYearOfManufacture(request.getYearOfManufacture());
        aircraft.setRegistrationDate(request.getRegistrationDate());
        aircraft.setNextMaintenanceDate(request.getNextMaintenanceDate());
        // Status and availability can be updated separately if needed
        // For now, we will not update status and availability based on the request
        // as they might require additional business logic
        aircraft.setStatus(AircraftStatus.ACTIVE); // This can be modified based on business rules
        aircraft.setIsAvailable(request.getIsAvailable()); // This can be modified based on business rules
        aircraft.setCurrentAirportId(request.getCurrentAirportId());
    }
}
