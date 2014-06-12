package net.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * @author krisjin
 * @date 2014-6-12下午2:06:12
 */

public class XMemCachedClient implements ICacheClient {

	private MemcachedClient memcachedClient;

	public XMemCachedClient() {
	}

	public void init(String host, int port) throws IOException {
		synchronized (this) {
			if (memcachedClient == null) {
				MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(host + ":" + port));
				memcachedClient = builder.build();
			}
		}

	}

	public void destroy() {
		try {
			memcachedClient.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public <T> T get(String key) throws CacheException {
		try {
			return memcachedClient.get(key);
		} catch (TimeoutException e) {
			
			throw new CacheException(e.getMessage());
		} catch (InterruptedException e) {
			throw new CacheException(e.getMessage());
		} catch (MemcachedException e) {
			throw new CacheException(e.getMessage());
		}
		
	}

	public <T> T get(String key, int timeout) throws CacheException {
		
		try {
			return memcachedClient.get(key,timeout);
		} catch (TimeoutException e) {
			
			throw new CacheException(e.getMessage());
		} catch (InterruptedException e) {
			throw new CacheException(e.getMessage());
		} catch (MemcachedException e) {
			throw new CacheException(e.getMessage());
		}
	}

	public void set(String key,int exp, Object value) {
		try {
			memcachedClient.set(key, exp, value);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws CacheException {
		XMemCachedClient xm = new XMemCachedClient();
		try {
			xm.init("192.168.233.128", 11211);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		Message msg = new Message();
//		msg.setMessageId(1);
//		msg.setContent("hello,everyone!");
//		xm.set("1", 0, msg);
		
		
		Message m =(Message)xm.get("1");
		System.out.println(m.getContent());
		xm.destroy();
	}
}
