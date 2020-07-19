package com.test.dataconsumer.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table
@Entity
public class DeviceServiceInfo {

    @Id
    private Long id;

    private String deviceId;

    private String availableService;

    @ManyToOne
    @JoinColumn(name = "deviceId")
    private DeviceInfo deviceInfo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deviceServiceInfo")
    private Set<ServiceStatusLog> serviceStatusLogs;
}
