/**
 * 
 */
package net.i77soft.spring.mvc3.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shines77
 *
 */

public final class StaticController {

	private final static String baseurl = "/spring_mvc3/";

	public final static void addGlobalObjects(ModelAndView mv) {
		addGlobalObjects(mv.getModelMap());
	}

	public final static void addGlobalObjects(Model model) {
		model.addAttribute("baseurl", baseurl);
	}

	public final static void addGlobalObjects(ModelMap model) {
		model.addAttribute("baseurl", baseurl);
	}

}
