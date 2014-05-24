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
@RequestMapping(value = "/")
public class RegisterController {

	private final static Log log = LogFactory.getLog(RegisterController.class);

	/*
	 * Why is my Spring 3 Validator Validating Everything on the Model?
	 * 
	 * Reference: http://stackoverflow.com/questions/4715860/why-is-my-spring-3-validator-validating-everything-on-the-model
	 */
	@InitBinder("User")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

	@RequestMapping(value = "/test/form_validate", method = RequestMethod.GET)
	public ModelAndView form_validate()
	{
		User user = new User();
		ModelAndView mv = new ModelAndView("test/form_validate");
		HomeController.addBaseURL(mv);
		mv.addObject("hello", "Hello World!");    // model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("client.User");
		mv.addObject("client", client);    // 再增加一个名为client的自定义对象
		//((Model) mv).addAttribute(new User());
		mv.addObject(user);
		return mv;
	}

	@RequestMapping(value = "/test/form_validate", method = RequestMethod.POST)
	//public void doRegister(@Validated User user, BindingResult result, Model model)
	public ModelAndView doRegister(@Validated User user, BindingResult result, ModelAndView mv)
	{
		HomeController.addBaseURL(mv);
		if (log.isDebugEnabled()) {
			log.debug("process url [/user], method [post] in " + getClass());
		}

		// 校验没有通过
		if (result.hasErrors()) {
			//model.addAttribute("errors", result.getFieldErrors());
			//return "test/form_validate";
			mv.addObject("errors", result.getFieldErrors());
			mv.addObject("user_form_errors", result.getFieldErrors().toString());
		}
		else {
			mv.addObject("errors", "have errors");
			//mv.addObject("user_form_errors", "have user_form_errors");
			mv.addObject("user_form_errors", result.getFieldErrors().toString());
		}

		if (user != null) {
			//userService.saveUser(user);
		}

		//return "test/form_validate";
		return mv;
	}

}
