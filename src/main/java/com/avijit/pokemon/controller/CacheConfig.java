package com.avijit.pokemon.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {
    private static final int CACHE_MAX_SIZE = 100; // Maximum number of entries in the cache
    private static final long CACHE_EXPIRY_TIME = 60; // Expiry time in seconds

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("cacheName");
        cacheManager.setCaffeine(caffeineCacheBuilder());

        return cacheManager;
    }

    private Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .maximumSize(CACHE_MAX_SIZE)
                .expireAfterWrite(CACHE_EXPIRY_TIME, TimeUnit.SECONDS);
    }
}
