package com.test.datacollector.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String deviceClass;
    private long number;
    private String name;
}
