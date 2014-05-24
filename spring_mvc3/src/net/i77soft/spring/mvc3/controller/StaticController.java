/**
 * 
 */
package net.i77soft.spring.mvc3.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 *
 */

public final class StaticController {

	private final static String baseurl = "/spring_mvc3/";

	public final static void addBaseURL(ModelAndView mv) {
		addBaseURL(mv.getModelMap());
	}

	public final static void addBaseURL(Model model) {
		model.addAttribute("baseurl", baseurl);
	}

	public final static void addBaseURL(ModelMap model) {
		model.addAttribute("baseurl", baseurl);
	}

}
