/**
 * 
 */
package net.i77soft.spring.mvc3.controller;

import net.i77soft.spring.mvc3.model.Client;
import net.i77soft.spring.mvc3.model.User;
import net.i77soft.spring.mvc3.validator.UserValidator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shines77
 *
 */

@Controller
@RequestMapping(value = "/validate")
public class RegisterController {

	private final static Log log = LogFactory.getLog(RegisterController.class);

	/*
	 * Why is my Spring 3 Validator Validating Everything on the Model?
	 * 
	 * Reference: http://stackoverflow.com/questions/4715860/why-is-my-spring-3-validator-validating-everything-on-the-model
	 */
	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		System.out.println(".");
		System.out.println("========= RegisterController::initBinder() enter =========");
		binder.setValidator(new UserValidator());
		System.out.println("========= RegisterController::initBinder() over =========");
		System.out.println(".");
	}

	@RequestMapping(value = "/form_validate", method = RequestMethod.GET)
	public ModelAndView form_validate()
	{
		User user = new User();
		ModelAndView mv = new ModelAndView("validate/form_validate");
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("client.User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象
		//((Model) mv).addAttribute(new User());
		mv.addObject(user);
		return mv;
	}

	@RequestMapping(value = "/form_validate", method = RequestMethod.POST)
	public ModelAndView doRegister(@Validated User user, BindingResult errors, ModelAndView mv)
	{
		StaticController.addGlobalObjects(mv);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("client.User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象

		if (log.isDebugEnabled()) {
			log.debug("process url [/user], method [post] in " + getClass());
		}

		// 校验没有通过
		if (errors.hasErrors()) {
			mv.addObject("errors", errors.getFieldErrors());
			return mv;
		}

		if (user != null) {
			//userService.saveUser(user);
		}

		ModelAndView newMV = new ModelAndView("validate/reg_success");
		StaticController.addGlobalObjects(newMV);
		newMV.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client newClient = new Client();
		newClient.setName("client.User");
		newMV.addObject("client", newClient);    		// 再增加一个名为client的自定义对象
		return newMV;
	}

	@RequestMapping(value = "/validate/form_validate2", method = RequestMethod.POST)
	public void doRegister(@Validated User user, BindingResult errors, ModelMap model)
	{
		StaticController.addGlobalObjects(model);
		model.addAttribute("hello", "Hello World!");    // model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("client.User");
		model.addAttribute("client", client);    		// 再增加一个名为client的自定义对象

		if (log.isDebugEnabled()) {
			log.debug("process url [/user], method [post] in " + getClass());
		}

		// 校验没有通过
		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getFieldErrors());
			//return "test/form_validate";
		}

		if (user != null) {
			//userService.saveUser(user);
		}
	}

}
