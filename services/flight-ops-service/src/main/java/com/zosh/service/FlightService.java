package com.zosh.service;

import com.zosh.enums.FlightStatus;
import com.zosh.payload.request.FlightRequest;
import com.zosh.payload.response.FlightResponse;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface FlightService {

    FlightResponse createFlight(Long airlineId, FlightRequest request);

    Page<FlightResponse> getFlightsByAirlineId(Long airlineId,
                                               Long departureAirportId,
                                               Long arrivalAirportId,
                                               Pageable pageable);
    FlightResponse getFlightById(Long id) throws Exception;

    FlightResponse updatedFlight(Long id, FlightRequest request);

    FlightResponse changeStatus(Long id, FlightStatus status);

    void deleteFlight(Long id);
}
