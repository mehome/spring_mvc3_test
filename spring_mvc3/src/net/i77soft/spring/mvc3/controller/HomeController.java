package net.i77soft.spring.mvc3.controller;

import net.i77soft.spring.mvc3.model.Client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@SuppressWarnings("unused")
	private final static Log log = LogFactory.getLog(HomeController.class);

	@RequestMapping("/")
	public ModelAndView index_home()
	{
		ModelAndView mv = new ModelAndView("home/welcome");
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView welcome()
	{
		ModelAndView mv = new ModelAndView("home/welcome");
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象
		return mv;
	}

	@RequestMapping(value = {"/index.htm", "/index.html"})
	//public ModelAndView index_html(HttpServletRequest request, HttpSession session)
	public ModelAndView index_html()
	{
		ModelAndView mv = new ModelAndView("index");
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象
		return mv;
	}

	@RequestMapping("/index.jsp")
	public ModelAndView index_jsp()
	{
		ModelAndView mv = new ModelAndView("index");
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象
		return mv;
	}

	@RequestMapping("/hello.html")
	public ModelAndView hello()
	{
		return new ModelAndView("helloForm");
	}

	@RequestMapping("/test.html")
	public ModelAndView test()
	{
		return new ModelAndView("helloForm");
	}

}
