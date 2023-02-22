package com.deary.Collabdiary.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Endpoint(id = "feature")
public class FeatureEndpoint {
    private final Map<String, Feauture> feautureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        feautureMap.put("BookFeature1", new Feauture(true));
        feautureMap.put("User", new Feauture(false));
        feautureMap.put("Auth", new Feauture(false));
    }

    @ReadOperation
    public Map<String, Feauture> feautures() {
        return feautureMap;
    }

    @ReadOperation
    public Feauture feature(@Selector String featureName) {
        return feautureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feauture {
        private boolean isEnabled;

    }
}
