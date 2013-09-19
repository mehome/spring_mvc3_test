package net.i77soft.ehcache;

import java.util.List;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EHCache
 */
public class EhCache implements Cache {

	private net.sf.ehcache.Cache cache;

	/**
	 * Creates a new Hibernate pluggable cache based on a cache name.
	 * <p/>
	 *
	 * @param cache The underlying EhCache instance to use.
	 */
	public EhCache(net.sf.ehcache.Cache cache)
	{
		this.cache = cache;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List keys() throws CacheException
	{
		return cache.getKeys();
	}

	/**
	 * Gets a value of an element which matches the given key.
	 *
	 * @param key the key of the element to return.
	 * @return The value placed into the cache with an earlier put, or null if not found or expired
	 * @throws CacheException
	 */
	@Override
	public Object get(Object key) throws CacheException
	{
		try {
			if (key == null)
				return null;
			else {
				Element element = cache.get(key);
				if (element != null)
					return element.getObjectValue();
			}
			return null;
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

	/**
	 * Puts an object into the cache.
	 *
	 * @param key   a key
	 * @param value a value
	 * @throws CacheException if the {@link CacheManager}
	 *                        is shutdown or another {@link Exception} occurs.
	 */
	@Override
	public void update(Object key, Object value) throws CacheException
	{
		put(key, value);
	}

	/**
	 * Puts an object into the cache.
	 *
	 * @param key   a key
	 * @param value a value
	 * @throws CacheException if the {@link CacheManager}
	 *                        is shutdown or another {@link Exception} occurs.
	 */
	@Override
	public void put(Object key, Object value) throws CacheException
	{
		try {
			Element element = new Element(key, value);
			cache.put(element);
		}
		catch (IllegalArgumentException e) {
			throw new CacheException(e);
		}
		catch (IllegalStateException e) {
			throw new CacheException(e);
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

	/**
	 * Removes the element which matches the key.
	 * <p/>
	 * If no element matches, nothing is removed and no Exception is thrown.
	 *
	 * @param key the key of the element to remove
	 * @throws CacheException
	 */
	@Override
	public void remove(Object key) throws CacheException
	{
		try {
			cache.remove(key);
		}
		catch (IllegalStateException e) {
			throw new CacheException(e);
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

	/**
	 * Remove all elements in the cache, but leave the cache
	 * in a useable state.
	 *
	 * @throws CacheException
	 */
	@Override
	public void clear() throws CacheException
	{
		try {
			cache.removeAll();
		}
		catch (IllegalStateException e) {
			throw new CacheException(e);
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

	/**
	 * Remove the cache and make it unuseable.
	 *
	 * @throws CacheException
	 */
	@Override
	public void destroy() throws CacheException
	{
		try {
			cache.getCacheManager().removeCache(cache.getName());
		}
		catch (IllegalStateException e) {
			throw new CacheException(e);
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

}
