package com.test.datacollector.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    private String availableService;
    private Double currentTemp;
    private long generationTime;
}
