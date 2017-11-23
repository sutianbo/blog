package com.blog.core.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration  
public class RedisConfig {
    
	@Autowired
	RedisConnectionFactory redisConnectionFactory;
      
    @Bean
    public <V> RedisTemplate<String, V> redisTemplate() {
    	RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
    	redisTemplate.setConnectionFactory(redisConnectionFactory);
    	Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    	ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
    	redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
    	redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    	redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
    	redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    	redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    
    @Bean
    public <V> ValueOperations<String, V> valueOperations(RedisTemplate<String, V> redisTemplate){
    	return redisTemplate.opsForValue();
    }
    
    @Bean
    public <HK,HV> HashOperations<String, HK, HV> hashOperations(RedisTemplate<String, ?> redisTemplate){
    	return redisTemplate.opsForHash();
    }
    
    @Bean
    public <V> ListOperations<String, V> listOperations(RedisTemplate<String, V> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public <V> SetOperations<String, V> setOperations(RedisTemplate<String, V> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public <V> ZSetOperations<String, V> zSetOperations(RedisTemplate<String, V> redisTemplate) {
        return redisTemplate.opsForZSet();
    } 
}
