package net.i77soft.spring.mvc3.controller;

import java.util.ArrayList;
import java.util.List;

import net.i77soft.spring.mvc3.model.Client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/index.html")
	public ModelAndView index_html()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("hello", "Hello");    // model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    // 再增加一个名为client的自定义对象
		return mv;
	}

	@RequestMapping("/index.jsp")
	public ModelAndView index_jsp()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("hello", "Hello");    // model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    // 再增加一个名为client的自定义对象
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

	/**
	 * 一个返回json的方法，用ResponseBody标识
	 * 可以在url中定义参数中，实现RESTful真是太简单了
	 * 传参很灵活，可以从url中取，也可以定义普通的
	 */
	@RequestMapping(value="/client/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	//@RequestMapping(value="/client/{name}", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Client getClient(@PathVariable String name, String title){
		System.out.println("ajax /client/" + name);
		Client client = new Client();
		client.setName(title + " " + name);

		return client;
	}

	@RequestMapping(value="/ajax1", method = RequestMethod.GET, headers = "Accept=application/json")
	//@RequestMapping(value="/ajax1", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Client getAjax1(String title) {
		System.out.println("ajax /ajax1 request--");

		Client client = new Client();
		client.setName("ajax1 test: title = " + title);

		return client;
	}

	@RequestMapping(value="/ajax2/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	//@RequestMapping(value="/ajax2/{name}", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Client> getAjax2(@PathVariable String name, String title) {
		System.out.println("ajax /ajax2/" + name);

		List<Client> clientList = new ArrayList<Client>();
		for (int i=0; i<5; i++) {
			Client client = new Client();
			client.setName("ajax2 test" + (i + 1));
			clientList.add(client);
		}

		return clientList;
	}
}

