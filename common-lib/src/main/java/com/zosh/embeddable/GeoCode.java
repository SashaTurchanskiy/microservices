package com.zosh.embeddable;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoCode {

    private Double latitude;
    private Double longitude;
}
