package com.zosh.repository;

import com.zosh.model.Flight;
import com.zosh.payload.response.FlightResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT  f FROM Flight f " +
            "where f.airlineId =: airlineId " +
            "and (:depId is null  or f.departureAirportId = :depId)" +
            "and (:arrId is null  or f.arrivalAirportId = :arrId)")
    Page<Flight> findByAirlineId(@Param("airlineId") Long airlineId,
                                 @Param("depId") Long depId,
                                 @Param("arrId") Long arrId,
                                 Pageable pageable);

    boolean existsByFlightNumber(String flightNumber);

}
