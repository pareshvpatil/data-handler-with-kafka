package com.test.datacollector;

import com.test.datacollector.api.DataCollectorAPI;
import com.test.datacollector.models.api.DataCollectorRequest;
import com.test.datacollector.models.api.DataCollectorResponse;
import com.test.datacollector.models.api.Service;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class kafkaMessageProducerTest {

    @Autowired
    private DataCollectorAPI dataCollectorAPI;

    @Test
    public void testMessagePublish() {
        DataCollectorRequest request = new DataCollectorRequest();
        request.setUri("http://localhost:8080");
        request.setId("sample-device-id");
        request.setName("Test Device");
        request.setKeywords(Arrays.asList("k1", "k2", "k3"));
//        request.setServices(Collections.singletonList(Service.builder()
//                .availableService("test-service").currentTemp(45.43d).generationTime(DateTime.now().getMillis()).build()));

        ResponseEntity<DataCollectorResponse> responseEntity = dataCollectorAPI.collectDeviceData(request);

        assertNotNull(responseEntity);
    }
}
