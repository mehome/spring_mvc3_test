/**
 * 
 */
package net.i77soft.spring.mvc3.init;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author shines77
 *
 */

@Configuration
@ComponentScan
@EnableWebMvc
//@ComponentScan("net.i77soft.spring.mvc3")
public class BaseAppConfig {
	/*
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	//*/
}
