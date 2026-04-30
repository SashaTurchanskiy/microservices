package com.zosh.service;

import com.zosh.payload.request.AircraftRequest;
import com.zosh.payload.request.AirlineRequest;
import com.zosh.payload.response.AircraftResponse;

import java.util.List;

public interface AircraftService {

    AircraftResponse createAircraft(AircraftRequest request, Long ownerId) throws Exception;
    AircraftResponse getById(Long id) throws Exception;
    List<AircraftResponse> listAllAircraftByOwner(Long ownerId) throws Exception;
    AircraftResponse updateAircraft(AirlineRequest request, Long ownerId);
    void deleteAircraft(Long id, Long ownerId);
}
