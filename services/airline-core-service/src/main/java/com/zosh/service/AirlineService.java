package com.zosh.service;

import com.zosh.enums.AirlineStatus;
import com.zosh.payload.request.AirlineRequest;
import com.zosh.payload.response.AirlineDropdownItem;
import com.zosh.payload.response.AirlineResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService {

    AirlineResponse createAirline(AirlineRequest request, Long ownerId);

    AirlineResponse getAirlineByOwner(Long ownerId) throws Exception;

    AirlineResponse getAirlineById(Long id) throws Exception;

    AirlineResponse updateAirline(AirlineRequest request, Long ownerId) throws Exception;

    Page<AirlineResponse> getAllAirlines(Pageable pageable);

    void deleteAirline(Long id, Long ownerId) throws Exception;

    AirlineResponse changeStatusByAdmin(Long airlineId, AirlineStatus status) throws Exception;

    List<AirlineDropdownItem> getAirlineDropdown();

}
