package com.test.datacollector.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectorResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private int status;
}
