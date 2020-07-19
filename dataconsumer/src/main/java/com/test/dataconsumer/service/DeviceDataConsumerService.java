package com.test.dataconsumer.service;

import com.test.dataconsumer.database.repositories.DeviceInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeviceDataConsumerService {
    private final DeviceInfoRepository deviceInfoRepository;
}
