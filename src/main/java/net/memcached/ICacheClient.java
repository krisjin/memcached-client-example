package net.memcached;

/**
 * @author krisjin
 * @date 2014-6-12下午2:39:18
 */

public interface ICacheClient {
	public <T> T get(String key) throws CacheException;
	
	public <T> T get(String key ,int timeout) throws CacheException;
	
	public void set(String key,int exp, Object value);
}
