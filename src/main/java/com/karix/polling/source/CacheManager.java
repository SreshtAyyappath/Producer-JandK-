package com.karix.polling.source;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheManager {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public String getFromCache(String templateId) {
        return cache.get(templateId); // Retrieve data from the cache
    }

    public void putInCache(String templateId, String templateTxt) {
        cache.put(templateId, templateTxt); // Store data in the cache
    }

    public void removeFromCache(String templateId) {
        cache.remove(templateId); // Remove data from the cache
    }


}