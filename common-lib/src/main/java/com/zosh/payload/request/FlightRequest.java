package com.zosh.payload.request;

import com.zosh.enums.FlightStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightRequest {

    @NotBlank(message = "Flight number is required")
    @Size(max = 10)
    private String flightNumber;

    private Long airlineId;

    @NotNull(message = "Aircraft ID is required")
    private Long aircraftId;

    @NotNull(message = "Departure airport Id is required")
    private Long departureAirportId;

    @NotNull(message = "Arrival airport Id is required")
    private Long arrivalAirportId;

    private FlightStatus status;
}
