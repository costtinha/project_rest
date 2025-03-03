package com.product.product_rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.product.product_rest.Persistance")
@EnableRedisRepositories(basePackages = "com.product.product_rest.Cache")
public class RepositoryConfig {
}
