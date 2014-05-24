/**
 * 
 */
package net.i77soft.spring.mvc3.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author shines77
 * 
 * Reference: http://www.petrikainulainen.net/programming/tips-and-tricks/creating-restful-urls-with-spring-mvc-3-1-part-two-dispatcher-servlet-url-mappings/
 * Reference: http://stackoverflow.com/questions/13455314/spring-mvc-implementation-of-webapplicationinitializer
 * Reference: http://blog.csdn.net/uyehgdhg/article/details/17952769
 */

@Configuration
@ComponentScan
@EnableWebMvc
//@ComponentScan("net.i77soft.spring.mvc3")
public class BaseAppConfig {
	///*
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	//*/
}
