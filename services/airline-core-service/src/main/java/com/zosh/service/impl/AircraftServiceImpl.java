package com.zosh.service.impl;

import com.zosh.mapper.AircraftMapper;
import com.zosh.mapper.AirlineMapper;
import com.zosh.model.Aircraft;
import com.zosh.model.Airline;
import com.zosh.payload.request.AircraftRequest;
import com.zosh.payload.request.AirlineRequest;
import com.zosh.payload.response.AircraftResponse;
import com.zosh.repository.AircraftRepository;
import com.zosh.repository.AirlineRepository;
import com.zosh.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;

    @Override
    public AircraftResponse createAircraft(AircraftRequest request, Long ownerId) throws Exception {
        Airline airline = airlineRepository.findByOwnerId(ownerId)
                .orElseThrow(()-> new Exception("Airline not found for ownerId: " + ownerId));

        Aircraft aircraft = AircraftMapper.toEntity(request, airline);
        if (aircraftRepository.existsByCode(aircraft.getCode())){
            throw new Exception("Aircraft with code " + aircraft.getCode() + " already exists.");
        }
        if (aircraft.getSeatingCapacity() < aircraft.getTotalSeats()){
            throw new Exception("Seating capacity cannot be less than total seats.");
        }
        return AircraftMapper.toResponse(aircraftRepository.save(aircraft));
    }

    @Override
    public AircraftResponse getById(Long id) throws Exception {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(()-> new Exception("Aircraft not exist with given id " + id));
        return AircraftMapper.toResponse(aircraft);
    }

    @Override
    public List<AircraftResponse> listAllAircraftByOwner(Long ownerId) throws Exception {
        Airline airline = airlineRepository.findByOwnerId(ownerId)
                .orElseThrow(()-> new Exception("This owner don`t have airline"));
        return aircraftRepository.findByAirlineId(airline.getId())
                .stream()
                .map(AircraftMapper::toResponse)
                .toList();
    }

    @Override
    public AircraftResponse updateAircraft(Long id, AircraftRequest request, Long ownerId) throws Exception {
        Airline airline = airlineRepository.findByOwnerId(ownerId)
                .orElseThrow(()-> new Exception("This owner don`t have airline"));

        Aircraft aircraft = aircraftRepository.findByIdAndAirlineId(id, airline.getId());
        if (aircraft == null){
            throw new Exception("Aircraft not exist with id");
        }
        if (request.getCode() != null
                && !aircraft.getCode().equals(request.getCode())
                && aircraftRepository.existsByCode(request.getCode())){
            throw new Exception("Code already exist with another aircraft");
        }
        AircraftMapper.updateEntity(aircraft, request);
        return AircraftMapper.toResponse(aircraftRepository.save(aircraft));
    }

    @Override
    public void deleteAircraft(Long id, Long ownerId) throws Exception {
        Airline airline = airlineRepository.findByOwnerId(ownerId)
                .orElseThrow(()-> new Exception("This owner don`t have airline"));
        Aircraft aircraft = aircraftRepository.findByIdAndAirlineId(id, airline.getId());
        if (aircraft == null) {
            throw new Exception("Aircraft not exist with id");
        }
        aircraftRepository.delete(aircraft);

    }
}
