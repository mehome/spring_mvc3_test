/**
 * Spring MVC 3.2.4 interceptor(拦截器)
 */
package net.i77soft.spring.mvc3.interceptor;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.i77soft.dbutils.DBManager;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author shines77
 *
 */
public class DBManagerHandlerInterceptor extends HandlerInterceptorAdapter {

	private static boolean DBManager_Inited = false;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println(".");
		System.out.println("========= DBManagerHandlerInterceptor preHandle =========");
		if (!DBManager_Inited) {
			DBManager.initDataSource(request.getServletContext(), null);
			DBManager_Inited = true;
		}
		@SuppressWarnings("unused")
		Connection conn = DBManager.getConnection();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("========= DBManagerHandlerInterceptor postHandle =========");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex) throws Exception {
		DBManager.closeConnection();
		System.out.println("========= DBManagerHandlerInterceptor afterCompletion =========");
		System.out.println(".");
	}
}
