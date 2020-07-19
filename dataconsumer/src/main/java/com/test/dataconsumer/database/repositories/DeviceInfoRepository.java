package com.test.dataconsumer.database.repositories;

import com.test.dataconsumer.database.entities.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, String> {
}
