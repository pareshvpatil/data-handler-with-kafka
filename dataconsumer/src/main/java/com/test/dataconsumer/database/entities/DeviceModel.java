package com.test.dataconsumer.database.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
public class DeviceModel {

    @Id
    private String deviceId;

    private String deviceClass;
    private long number;
    private String name;
}
