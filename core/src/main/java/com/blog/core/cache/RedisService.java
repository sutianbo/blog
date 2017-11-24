package com.blog.core.cache;

import java.util.concurrent.TimeUnit;

/**
 * key都用String类型
 * @author sutb
 * @time:2017年11月23日
 */
public interface RedisService<V> {

	Boolean exists(String key);

	void delete(String key);

	Long getExpire(String key);

	Boolean expire(String key, long timeout, TimeUnit unit);

	void set(String key, V value);

	void set(String key, V value, long timeout, TimeUnit unit);

	V get(String key);

	Boolean hExists(String key, Object hashKey);

	V hGet(String key, Object hashKey);

	void hSet(String key, Object hashKey, V value);

	Long hDel(String key, Object... hashKeys);

	Long hLen(String key);
}
