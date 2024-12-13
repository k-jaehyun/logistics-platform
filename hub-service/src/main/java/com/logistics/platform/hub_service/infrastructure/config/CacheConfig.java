package com.logistics.platform.hub_service.infrastructure.config;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean // Redis Cache 기본값 설정
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    // 설정 구성을 먼저 진행한다.
    // 아래 클래스로 Redis 를 이용해서 Spring Cache 를 사용할 때 Redis 관련 설정을 모아두는 클래스이다.
    RedisCacheConfiguration configuration = RedisCacheConfiguration
        .defaultCacheConfig()
        // null 은 캐싱하지 않겠다
        .disableCachingNullValues()
        // 기본 캐시 유지 시간 (Time to Live)
        .entryTtl(Duration.ofSeconds(10))
        // 캐시를 구분하는 접두사 설정
        .computePrefixWith(CacheKeyPrefix.simple())
        // 캐시에 저장할 값을 어떻게 직렬화 / 역직렬화 할것인지
        .serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java())
        );
    return RedisCacheManager
        .builder(connectionFactory)
        .cacheDefaults(configuration)
        .build();

  }
}
