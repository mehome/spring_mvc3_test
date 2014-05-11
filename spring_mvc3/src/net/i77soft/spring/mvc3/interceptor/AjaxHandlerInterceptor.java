/**
 * Spring MVC 3.2.4 interceptor(拦截器)
 */
package net.i77soft.spring.mvc3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author shines77
 *
 */
public class AjaxHandlerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("========= AjaxHandlerInterceptor preHandle =========");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("========= AjaxHandlerInterceptor postHandle =========");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex) throws Exception {
		System.out.println("========= AjaxHandlerInterceptor afterCompletion =========");
	}
}
