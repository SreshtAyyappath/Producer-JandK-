package com.karix.polling.source;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheManager {
    private final ConcurrentHashMap<BigDecimal, String> cache = new ConcurrentHashMap<>();

    public String getFromCache(BigDecimal templateId) {
        return cache.get(templateId); // Retrieve data from the cache
    }

    public void putInCache(BigDecimal templateId, String templateTxt) {
        cache.put(templateId, templateTxt); // Store data in the cache
    }

    public void removeFromCache(BigDecimal templateId) {
        cache.remove(templateId); // Remove data from the cache
    }


}