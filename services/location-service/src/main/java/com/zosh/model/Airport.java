package com.zosh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zosh.embeddable.Address;
import com.zosh.embeddable.GeoCode;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 3)
    private String iataCode;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private GeoCode geoCode;

    @Column(name = "time_zone", length = 50)
    private ZoneId timeZone;

    @ManyToOne
    @JsonIgnore
    private City city;

    @JsonIgnore
    @Transient
    public String getDetailedName(){
        if (city != null && city.getCountryCode() != null){
            return name.toUpperCase() + "/" + city.getCountryCode();
        }
        return name.toUpperCase();
    }
}
