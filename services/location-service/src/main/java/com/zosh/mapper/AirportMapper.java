package com.zosh.mapper;

import com.zosh.model.Airport;
import com.zosh.payload.request.AirportRequest;
import com.zosh.payload.response.AirportResponse;

public class AirportMapper {

    public static Airport toEntity(AirportRequest request){
        if (request == null){return null;}

        return Airport.builder()
                .iataCode(request.getIataCode())
                .name(request.getName())
                //.timeZoneId(request.getTimeZone())
                .address(request.getAddress())
                .geoCode(request.getGeoCode())
                .build();
    }

    public static AirportResponse toResponse(Airport airport){
        if (airport == null){return null;}

        return AirportResponse.builder()
                .id(airport.getId())
                .iataCode(airport.getIataCode())
                .name(airport.getName())
                .detailedName(airport.getDetailedName())
                //.timeZone(airport.getTimeZone())
                .address(airport.getAddress())
                .cityResponse(CityMapper.toResponse(airport.getCity()))
                .geoCode(airport.getGeoCode())
                .build();
    }

    public static void updateEntity(Airport airport, AirportRequest request){
        if (airport == null || request == null){return;}

        if (request.getIataCode() != null){
            airport.setIataCode(request.getIataCode());
        }
        if (request.getName() != null){
            airport.setName(request.getName());
        }
        if (request.getAddress() != null){
            airport.setAddress(request.getAddress());
        }
        if (request.getGeoCode() != null){
            airport.setGeoCode(request.getGeoCode());
        }
    }
}
