package com.example.order_service.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter
@Slf4j
public class JsonToMapConverter implements AttributeConverter<Map<String, Object>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> customerInfo) {
        String customerInfoJson = null;
        try {
            customerInfoJson = new ObjectMapper().writeValueAsString(customerInfo);
        } catch (JsonProcessingException e) {
            log.error("JSON writing error", e);
        }
        return customerInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String customerInfoJSON) {
        Map<String, Object> customerInfo = null;
        try {
            customerInfo = new ObjectMapper().readValue(customerInfoJSON, Map.class);
        } catch (IOException e) {
            log.error("JSON reading error", e);
        }
        return customerInfo;
    }
}
