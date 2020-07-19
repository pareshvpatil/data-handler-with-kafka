package com.test.dataconsumer.database.entities;

import com.test.dataconsumer.database.helper.ListConverter;
import com.test.dataconsumer.models.common.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Table
@Entity
public class DeviceInfo {

    @Id
    private String id;

    private String uri;
    private String name;

    @OneToOne(mappedBy = "deviceId")
    private DeviceLocation location;

    private String purpose;
    private String owner;

    @Convert(converter = ListConverter.class)
    private List<String> keywords;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "deviceInfo")
    private Set<DeviceServiceInfo> services;

    @OneToOne(mappedBy = "deviceId")
    private DeviceModel model;
}
