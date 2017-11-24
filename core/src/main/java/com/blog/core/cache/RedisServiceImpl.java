package com.blog.core.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisServiceImpl<V> implements RedisService<V>{
	
	@Autowired
	RedisTemplate<String, V> redisTemplate;
	@Autowired
	ValueOperations<String, V> valueOperations;
	@Autowired
	HashOperations<String, Object, V> hashOperations;
	
	public Boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}
	
	public void delete(String key) {
		 redisTemplate.delete(key);
	}
	
	public Long getExpire(String key) {
		return redisTemplate.getExpire(key);
	}
	
	public Boolean expire(String key,long timeout,TimeUnit unit) {
		return redisTemplate.expire(key, timeout, unit);
	}
	
	public void set(String key,V value) {
		valueOperations.set(key, value);
	}
	
	public void set(String key, V value, long timeout, TimeUnit unit) {
		valueOperations.set(key, value, timeout, unit);
	}
	
	public V get(String key) {
		return valueOperations.get(key);
	}

	public Boolean hExists(String key,Object hashKey) {
		return hashOperations.hasKey(key, hashKey);
	}
	
	public V hGet(String key,Object hashKey) {
		return hashOperations.get(key, hashKey);
	}
	
	public void hSet(String key,Object hashKey,V value) {
		hashOperations.put(key, hashKey, value);
	}
	
	public Long hDel(String key,Object... hashKeys) {
		return hashOperations.delete(key, hashKeys);
	}
	
	public Long hLen(String key) {
		return hashOperations.size(key);
	}
}
