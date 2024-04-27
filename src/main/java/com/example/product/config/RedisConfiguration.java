package com.example.product.config;


import com.example.product.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration;
import org.springframework.data.redis.core.convert.MappingConfiguration;
import org.springframework.data.redis.core.index.IndexConfiguration;
import org.springframework.data.redis.core.mapping.RedisMappingContext;

import java.util.Collections;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);


        return template;
    }

    public static class MyKeyspaceConfiguration extends KeyspaceConfiguration {

        @Override
        protected Iterable<KeyspaceSettings> initialConfiguration() {
            KeyspaceSettings keyspaceSettings = new KeyspaceSettings(Product.class, "PRODUCTS");
            keyspaceSettings.setTimeToLive(60L);
            return Collections.singleton(keyspaceSettings);
        }
    }
}
