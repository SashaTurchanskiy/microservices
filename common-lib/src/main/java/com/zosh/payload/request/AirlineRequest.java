package com.zosh.payload.request;

import com.zosh.enums.AirlineStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineRequest {

    @NotBlank(message = "IATA code is required")
    @Size(max = 2, message = "IATA code must be at most 2 characters")
    private String iataCode;

    @NotBlank(message = "ICAO code is required")
    @Size(max = 3, message = "ICAO code must be at most 3 characters")
    private String icaoCode;

    @NotBlank(message = "Name is required")
    private String name;

    private String alias;

    private String logoUrl;

    private String website;

    private AirlineStatus status;

    private String alliance;

    private Long headquartersCityId;

    private String supportEmail;
    private String supportPhone;
    private String supportHours;

}
