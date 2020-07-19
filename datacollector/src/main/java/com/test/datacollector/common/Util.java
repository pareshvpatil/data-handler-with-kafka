package com.test.datacollector.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.datacollector.models.api.DataCollectorRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
    private Util() {}

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String buildDeviceServiceTopic(DataCollectorRequest dataCollectorRequest) {
        //TODO: create a topic at each service level
        return Constants.TOPIC_PREFIX
                + dataCollectorRequest.getId();
    }

    @SneakyThrows
    public static String convertToJSON(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while serializing the object, e:", e);
            throw e;
        }
    }
}
