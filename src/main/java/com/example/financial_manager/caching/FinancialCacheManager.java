package com.example.financial_manager.caching;

import com.example.financial_manager.FinanceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FinancialCacheManager implements CacheManager {

    private final Map<String, Cache> caches = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);

    public FinancialCacheManager() {
        caches.put("expense", new ConcurrentMapCache("expense"));
        logger.info("FinancialCacheManager initialized.");
    }

    @Override
    public Cache getCache(String name) {
        logger.info("Cache " + name + " was used.");
        return caches.get(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return caches.keySet();
    }
}
