package com.test.dataconsumer.database.helper;

import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListConverter implements AttributeConverter<List, String> {
    @Override
    public String convertToDatabaseColumn(List attribute) {
        if (CollectionUtils.isEmpty(attribute)) {
            return "";
        }
        return new ArrayList<String>(attribute).stream().reduce("", (a1, a2) -> a1 + "," + a2);
    }

    @Override
    public List convertToEntityAttribute(String dbData) {
        if (!org.springframework.util.StringUtils.hasText(dbData)) {
            return Collections.emptyList();
        }
        return new ArrayList(Arrays.asList(dbData.split(",")));
    }
}
