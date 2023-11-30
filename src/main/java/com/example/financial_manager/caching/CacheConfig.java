package com.example.financial_manager.caching;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean(name = "FinancialCacheManager")
    public CacheManager cacheManager() {
        return new FinancialCacheManager();
    }

}
