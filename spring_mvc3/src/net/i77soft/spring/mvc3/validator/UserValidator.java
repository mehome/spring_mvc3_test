/**
 * 
 */
package net.i77soft.spring.mvc3.validator;

import net.i77soft.spring.mvc3.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author shines77
 *
 */
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	/*
	 * Reference: http://www.iteye.com/topic/828513?page=3
	 * 
	 * 错误一般有两大类：global error用reject，field error用rejectValue
	 * 
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "user.username.required", "用户名不能为空");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.required", "密码不能为空");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.required", "邮箱不能为空");

		User user = (User)target;
		int length = user.getUsername().length();
		if (length < 4) {
			errors.rejectValue("username", "user.username.too_short", "用户名不能少于{4}个字符");
		}
		else if (length > 20) {
			errors.rejectValue("username", "user.username.too_long", "用户名不能超过{20}个字符");
		}

		length = user.getPassword().length();
		if (length < 4) {
			errors.rejectValue("password", "user.password.too_short", "密码太短，不能少于{4}个字符");
		}
		else if (length > 20) {
			errors.rejectValue("password", "user.password.too_long", "密码太长，不能长于{20}个字符");
		}

		int index = user.getEmail().indexOf("@");
		length = user.getEmail().length();
		if (index == -1) {
			errors.rejectValue("email", "user.email.invalid_email", "邮箱格式错误");
		}
		else if ((length > 0) && ((length - index) <= 2)) {
			errors.rejectValue("email", "user.email.invalid_email", "邮箱格式错误");
		}
	}

}
