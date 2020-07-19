package com.test.datacollector.service;

import com.test.datacollector.common.Util;
import com.test.datacollector.models.api.DataCollectorRequest;
import com.test.datacollector.models.api.DataCollectorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataCollectorService {

    private final KafkaAdminClient kafkaAdminClient;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public DataCollectorResponse collect(DataCollectorRequest dataCollectorRequest) {
        CompletableFuture.runAsync(() -> consume(dataCollectorRequest));

        return DataCollectorResponse.builder()
                .message("Data Collected")
                .status(HttpStatus.ACCEPTED.value())
                .build();
    }

    private void consume(DataCollectorRequest dataCollectorRequest) {
        String deviceServiceTopic = Util.buildDeviceServiceTopic(dataCollectorRequest);
        kafkaAdminClient.listTopics(new ListTopicsOptions())
                .names().thenApply(topics -> {
            if (CollectionUtils.isEmpty(topics) || !topics.contains(deviceServiceTopic)) {
                createTopicAndPublishData(dataCollectorRequest, deviceServiceTopic);
            } else {
                kafkaTemplate.send(deviceServiceTopic, Util.convertToJSON(dataCollectorRequest));
            }
            return KafkaFuture.completedFuture("Message Published");
        });
    }

    private void createTopicAndPublishData(DataCollectorRequest dataCollectorRequest, String deviceServiceTopic) {
        CreateTopicsResult createTopicsResult = kafkaAdminClient.createTopics(
                Collections.singletonList(
                        new NewTopic(deviceServiceTopic, 1, Short.decode("1"))));
        try {
            createTopicsResult.values().get(deviceServiceTopic).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred: ", e);
        }
        kafkaTemplate.send(deviceServiceTopic, Util.convertToJSON(dataCollectorRequest));
    }
}
