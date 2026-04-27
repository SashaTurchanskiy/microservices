package com.zosh.payload.response;

import lombok.Data;

@Data
public class AirlineDropdownItem {

    private Long id;
    private String name;
    private String iataCode;
    private String icaoCode;
    private String logoUrl;
    private String country;
}
