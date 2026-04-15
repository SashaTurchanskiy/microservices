package com.zosh.service.impl;

import com.zosh.mapper.AirportMapper;
import com.zosh.model.Airport;
import com.zosh.model.City;
import com.zosh.payload.request.AirportRequest;
import com.zosh.payload.response.AirportResponse;
import com.zosh.repository.AirportRepository;
import com.zosh.repository.CityRepository;
import com.zosh.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;

    @Override
    public AirportResponse createAirport(AirportRequest request) throws Exception {

        if (airportRepository.findByIataCode(request.getIataCode()).isPresent()){
            throw new Exception("Airport with IATA code " + request.getIataCode() + " already exists.");
        }
        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(()-> new Exception("City with ID " + request.getCityId() + " not found."));
        Airport airport = AirportMapper.toEntity(request);
        airport.setCity(city);
        Airport savedAirport = airportRepository.save(airport);
        return AirportMapper.toResponse(savedAirport);
    }

    @Override
    public AirportResponse getAirportById(Long id) throws Exception {
        Airport airport =  airportRepository.findById(id)
                .orElseThrow(()-> new Exception("Airport with ID " + id + " not found."));
        return AirportMapper.toResponse(airport);
    }

    @Override
    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(AirportMapper::toResponse)
                .toList();
    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) throws Exception {

        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(()-> new Exception("Airport with ID " + id + " not found."));

        if (request.getIataCode() != null && !existingAirport.getIataCode().equals(request.getIataCode())
        && airportRepository.findByIataCode(request.getIataCode()).isPresent()){
            throw new Exception("Airport with IATA code " + request.getIataCode() + " already exists.");
        }

        AirportMapper.updateEntity(existingAirport, request);

        Airport updatedAirport = airportRepository.save(existingAirport);

        return AirportMapper.toResponse(updatedAirport);
    }

    @Override
    public void deleteAirport(Long id) throws Exception {
        Airport airport =  airportRepository.findById(id)
                .orElseThrow(()-> new Exception("Airport with ID " + id + " not found."));
        airportRepository.delete(airport);
    }

    @Override
    public List<AirportResponse> getAirportsByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId).stream()
                .map(AirportMapper::toResponse)
                .toList();
    }
}
