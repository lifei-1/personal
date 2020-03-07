package com.rrz.main.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWaitMillis;

	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.block-when-exhausted}")
	private boolean blockWhenExhausted;

	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;

	@Bean
	public JedisPool redisPoolFactory() throws Exception {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setMaxTotal(maxActive);
		jedisPoolConfig.setMinIdle(minIdle);
		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
		// 是否启用pool的jmx管理功能, 默认true
		jedisPoolConfig.setJmxEnabled(true);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);

		return jedisPool;
	}

}
