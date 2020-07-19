package com.test.dataconsumer.database.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
public class DeviceLocation {

    @Id
    private String deviceId;

    private String name;
    private String latitude;
    private String longitude;
}
