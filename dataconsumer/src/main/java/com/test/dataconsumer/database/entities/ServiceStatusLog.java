package com.test.dataconsumer.database.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class ServiceStatusLog {

    @Id
    private Long id;

    private Long deviceServiceId;

    private Double currentTemp;

    private Long generationTime;

    @ManyToOne
    @JoinColumn(name = "deviceServiceId")
    private DeviceServiceInfo deviceServiceInfo;
}
