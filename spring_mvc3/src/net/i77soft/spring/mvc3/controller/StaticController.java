/**
 *
 */
package net.i77soft.spring.mvc3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shines77
 *
 * Spring MVC Request URLs in JSP
 *
 * Reference: http://stackoverflow.com/questions/6970115/spring-mvc-request-urls-in-jsp
 *
 * <a href="${contextPath}/admin/listPeople">Go to People List</a>
 *
 * <c:url value="/admin/listPeople"/>
 *
 * Root URl of the servlet
 *
 * Reference: http://stackoverflow.com/questions/1629102/root-url-of-the-servlet/1629133#1629133
 * Reference: http://stackoverflow.com/questions/5012525/get-root-base-url-in-spring-mvc
 *
 * You do realize that the URL client sees (and/or types into his browser)
 *   and the URL served by the container your servlet is deployed on can be very different?
 *
 * In order to get the latter, though, you have a few methods available on HttpServletRequest:
 *
 *   You can either call getScheme(), getServerName(), getServerPort() and getContextPath()
 *       and combine them using appropriate separators;
 *   OR you can call getRequestURL() and remove getServletPath() and getPathInfo() from it.
 *
 */

public final class StaticController {

	private static boolean baseURL_inited = false;
	private static String baseURL = "";

	private final static void getBaseURL(HttpServletRequest request) {
		if (baseURL_inited || request == null)
			return;

		if (baseURL.isEmpty() || baseURL == null) {
			if (request != null) {
				baseURL = request.getContextPath();
				baseURL_inited = true;

				System.out.println(".");
				System.out.println("========= StaticController::getBaseURL() =========");
				System.out.println(" baseURL = " + baseURL);
				System.out.println(".");
			}
		}
	}

	public final static void setBaseURL(String strContextPath) {
		if (!strContextPath.isEmpty()) {
			baseURL = strContextPath;
			baseURL_inited = true;

			System.out.println(".");
			System.out.println("========= StaticController::setBaseURL() =========");
			System.out.println(" baseURL = " + baseURL);
			System.out.println(".");
		}
	}

	public final static void addGlobalObjects(ModelAndView mv) {
		addGlobalObjects(mv.getModelMap());
	}

	public final static void addGlobalObjects(Model model) {
		model.addAttribute("baseURL", baseURL);
	}

	public final static void addGlobalObjects(ModelMap model) {
		model.addAttribute("baseURL", baseURL);
	}

	public final static void addGlobalObjects(ModelAndView mv, HttpServletRequest request) {
		getBaseURL(request);
		addGlobalObjects(mv.getModelMap());
	}

	public final static void addGlobalObjects(Model model, HttpServletRequest request) {
		getBaseURL(request);
		addGlobalObjects(model);
	}

	public final static void addGlobalObjects(ModelMap model, HttpServletRequest request) {
		getBaseURL(request);
		addGlobalObjects(model);
	}

}
