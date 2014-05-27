package net.i77soft.dbutils;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.i77soft.Configurations;
import net.i77soft.ehcache.CacheManager;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 数据库查询助手
 *
 * @author Winter Lau<br>
 *
 * @modified: shines77
 *
 * 参考: http://commons.apache.org/proper/commons-dbutils/examples.html
 *
 */
@SuppressWarnings("unchecked")
public class QueryHelper {

	private final static QueryRunner _g_runner = new QueryRunner();

	@SuppressWarnings("rawtypes")
	private final static ColumnListHandler _g_columnListHandler = new ColumnListHandler() {
		@Override
		protected Object handleRow(ResultSet rs) throws SQLException {
			Object obj = super.handleRow(rs);
			if (obj instanceof BigInteger)
				return ((BigInteger) obj).longValue();
			return obj;
		}

	};

	@SuppressWarnings("rawtypes")
	private final static ScalarHandler _g_scalarHandler = new ScalarHandler() {
		@Override
		public Object handle(ResultSet rs) throws SQLException {
			Object obj = super.handle(rs);
			if (obj instanceof BigInteger)
				return ((BigInteger) obj).longValue();
			return obj;
		}
	};

	private final static ArrayHandler _g_arrayHandler = new ArrayHandler() {
		@Override
		public Object[] handle(ResultSet rs) throws SQLException {
			Object[] obj = super.handle(rs);
			return obj;
		}
	};

	private final static ArrayListHandler _g_arrayListHandler = new ArrayListHandler() {
		@Override
		public Object[] handleRow(ResultSet rs) throws SQLException {
			Object[] obj = super.handleRow(rs);
			return obj;
		}
	};

	private final static MapHandler _g_mapHandler = new MapHandler() {
		@Override
		public Map<String, Object> handle(ResultSet rs) throws SQLException {
			Map<String, Object> obj = super.handle(rs);
			return obj;
		}
	};

	private final static MapListHandler _g_mapListHandler = new MapListHandler() {
		@Override
		public Map<String, Object> handleRow(ResultSet rs) throws SQLException {
			Map<String, Object> obj = super.handleRow(rs);
			return obj;
		}
	};

	// Create a ResultSetHandler implementation to convert the
	// first row into an Object[].
	@SuppressWarnings("unused")
	private final static ResultSetHandler<Object[]> _g_arrayHandler2 = new ResultSetHandler<Object[]>() {
		@Override
		public Object[] handle(ResultSet rs) throws SQLException {
			if (!rs.next()) {
				return null;
			}

			ResultSetMetaData meta = rs.getMetaData();
			int cols = meta.getColumnCount();
			Object[] result = new Object[cols];

			for (int i = 0; i < cols; i++) {
				result[i] = rs.getObject(i + 1);
			}

			return result;
		}
	};

	// Create a ResultSetHandler implementation to convert all
	// the rows into an List<Object[]>.
	@SuppressWarnings("unused")
	private final static ResultSetHandler<List<Object[]>> _g_arrayListHandler2 = new ResultSetHandler<List<Object[]>>() {
		@Override
		public List<Object[]> handle(ResultSet rs) throws SQLException {
			List<Object[]> rows = new ArrayList<Object[]>();

			while (rs.next()) {
				ResultSetMetaData meta = rs.getMetaData();
				int cols = meta.getColumnCount();
				Object[] result = new Object[cols];
				for (int i = 0; i < cols; i++) {
					result[i] = rs.getObject(i + 1);
				}
				rows.add(result);
			}

			return rows;
		}
	};

	@SuppressWarnings("serial")
	private final static List<Class<?>> PrimitiveClasses = new ArrayList<Class<?>>() {
		{
			add(Long.class);
			add(Integer.class);
			add(Float.class);
			add(Double.class);
			add(String.class);
			add(java.util.Date.class);
			add(java.sql.Date.class);
			add(java.sql.Timestamp.class);
			add(java.sql.Time.class);
		}
	};

	private final static boolean _IsPrimitive(Class<?> cls) {
		return cls.isPrimitive() || PrimitiveClasses.contains(cls);
	}

	/**
	 * 获取数据库连接
	 *
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
			return Configurations.getConnection();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 关闭数据库连接
	 *
	 * @return void
	 */
	public static void closeConnection() {
		try {
			Configurations.closeConnection();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 读取某个对象
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T read(Class<T> beanClass, String sql, Object... params) {
		try {
			return (T) _g_runner.query(getConnection(), sql,
					_IsPrimitive(beanClass) ? _g_scalarHandler
							: new BeanHandler(beanClass), params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public static <T> T read_cache(Class<T> beanClass, String cache,
			Serializable key, String sql, Object... params) {
		T obj = (T) CacheManager.get(cache, key);
		if (obj == null) {
			obj = read(beanClass, sql, params);
			CacheManager.set(cache, key, (Serializable) obj);
		}
		return obj;
	}

	/**
	 * 对象查询
	 *
	 * @param <T>
	 * @param beanClass
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> query(Class<T> beanClass, String sql, Object... params) {
		try {
			return (List<T>) _g_runner.query(getConnection(), sql,
					_IsPrimitive(beanClass) ? _g_columnListHandler
							: new BeanListHandler(beanClass), params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 支持缓存的对象查询
	 *
	 * @param <T>
	 * @param beanClass
	 * @param cache_region
	 * @param key
	 * @param sql
	 * @param params
	 * @return
	 */
	public static <T> List<T> query_cache(Class<T> beanClass,
			String cache_region, Serializable key, String sql, Object... params) {
		List<T> objs = (List<T>) CacheManager.get(cache_region, key);
		if (objs == null) {
			objs = query(beanClass, sql, params);
			CacheManager.set(cache_region, key, (Serializable) objs);
		}
		return objs;
	}

	/**
	 * 分页查询
	 *
	 * @param <T>
	 * @param beanClass
	 * @param sql
	 * @param page
	 * @param count
	 * @param params
	 * @return
	 */
	public static <T> List<T> query_slice(Class<T> beanClass, String sql,
			int page, int count, Object... params) {
		if (page < 0 || count < 0)
			throw new IllegalArgumentException(
					"Illegal parameter of 'page' or 'count', Must be positive.");
		int from = (page - 1) * count;
		count = (count > 0) ? count : Integer.MAX_VALUE;
		return query(beanClass, sql + " LIMIT ?,?",
				ArrayUtils.addAll(params, new Integer[] { from, count }));
	}

	/**
	 * 支持缓存的分页查询
	 *
	 * @param <T>
	 * @param beanClass
	 * @param cache
	 * @param cache_key
	 * @param cache_obj_count
	 * @param sql
	 * @param page
	 * @param count
	 * @param params
	 * @return
	 */
	public static <T> List<T> query_slice_cache(Class<T> beanClass,
			String cache, Serializable cache_key, int cache_obj_count,
			String sql, int page, int count, Object... params) {
		List<T> objs = (List<T>) CacheManager.get(cache, cache_key);
		if (objs == null) {
			objs = query_slice(beanClass, sql, 1, cache_obj_count, params);
			CacheManager.set(cache, cache_key, (Serializable) objs);
		}
		if (objs == null || objs.size() == 0)
			return objs;
		int from = (page - 1) * count;
		if (from < 0)
			return null;
		// 超出缓存的范围
		if ((from + count) > cache_obj_count)
			return query_slice(beanClass, sql, page, count, params);
		int end = Math.min(from + count, objs.size());
		if (from >= end)
			return null;
		return objs.subList(from, end);
	}

	/**
	 * 执行统计查询语句，语句的执行结果必须只返回一个数值
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static long stat(String sql, Object... params) {
		try {
			Number num = (Number) _g_runner.query(getConnection(), sql,
					_g_scalarHandler, params);
			return (num != null) ? num.longValue() : -1;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行统计查询语句，语句的执行结果必须只返回一个数值
	 *
	 * @param cache_region
	 * @param key
	 * @param sql
	 * @param params
	 * @return
	 */
	public static long stat_cache(String cache_region, Serializable key,
			String sql, Object... params) {
		Number value = (Number) CacheManager.get(cache_region, key);
		if (value == null) {
			value = stat(sql, params);
			CacheManager.set(cache_region, key, value);
		}
		return value.longValue();
	}

	/**
	 * 执行SELECT语句(只返回第一条记录)
	 *
	 * @param sql
	 * @param params
	 * @return Object[]
	 */
	public static Object[] selectOne(String sql, Object... params) {
		try {
			return _g_runner.query(getConnection(), sql, _g_arrayHandler, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行SELECT语句(只返回第一条记录)
	 *
	 * @param sql
	 * @param params
	 * @return Object[]
	 */
	public static Object[] selectOne_cache(String cache_region, Serializable key,
			String sql, Object... params) {
		Object[] objs = (Object[]) CacheManager.get(cache_region, key);
		if (objs == null) {
			objs = selectOne(sql, params);
			CacheManager.set(cache_region, key, (Serializable) objs);
		}
		return objs;
	}

	/**
	 * 执行SELECT语句(返回多条记录)
	 *
	 * @param sql
	 * @param params
	 * @return List<Object[]>
	 */
	public static List<Object[]> select(String sql, Object... params) {
		try {
			return _g_runner.query(getConnection(), sql, _g_arrayListHandler, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行SELECT语句(返回多条记录)
	 *
	 * @param sql
	 * @param params
	 * @return List<Object[]>
	 */
	public static List<Object[]> select_cache(String cache_region, Serializable key,
			String sql, Object... params) {
		List<Object[]> objsList = (List<Object[]>) CacheManager.get(cache_region, key);
		if (objsList == null) {
			objsList = select(sql, params);
			CacheManager.set(cache_region, key, (Serializable) objsList);
		}
		return objsList;
	}

	/**
	 * 执行SELECT语句(只返回第一条记录)
	 *
	 * @param sql
	 * @param params
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> selectOne_map(String sql, Object... params) {
		try {
			return _g_runner.query(getConnection(), sql, _g_mapHandler, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行SELECT语句(只返回第一条记录)
	 *
	 * @param sql
	 * @param params
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> selectOne_map_cache(String cache_region, Serializable key,
			String sql, Object... params) {
		Map<String, Object> objs = (Map<String, Object>) CacheManager.get(cache_region, key);
		if (objs == null) {
			objs = selectOne_map(sql, params);
			CacheManager.set(cache_region, key, (Serializable) objs);
		}
		return objs;
	}

	/**
	 * 执行SELECT语句(返回多条记录)
	 *
	 * @param sql
	 * @param params
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> select_map(String sql, Object... params) {
		try {
			return _g_runner.query(getConnection(), sql, _g_mapListHandler, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行SELECT语句(返回多条记录)
	 *
	 * @param sql
	 * @param params
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> select_map_cache(String cache_region, Serializable key,
			String sql, Object... params) {
		List<Map<String, Object>> objsList = (List<Map<String, Object>>) CacheManager.get(cache_region, key);
		if (objsList == null) {
			objsList = select_map(sql, params);
			CacheManager.set(cache_region, key, (Serializable) objsList);
		}
		return objsList;
	}

	/**
	 * 执行INSERT/UPDATE/DELETE语句
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int execute(String sql, Object... params) {
		try {
			return _g_runner.update(getConnection(), sql, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * 执行UPDATE语句
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql, Object... params) {
		return execute(sql, params);
	}

	/**
	 * 执行INSERT语句
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int insert(String sql, Object... params) {
		return execute(sql, params);
	}

	/**
	 * 执DELETE语句
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int delete(String sql, Object... params) {
		return execute(sql, params);
	}

	/**
	 * 批量执行指定的SQL语句
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int[] batch(String sql, Object[][] params) {
		try {
			return _g_runner.batch(getConnection(), sql, params);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

}
