/**
 * 
 */
package net.i77soft.spring.mvc3.init;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import net.i77soft.dbutils.DBManager;

import org.springframework.web.WebApplicationInitializer;

/**
 * @author shines77
 * 
 * Reference: http://www.petrikainulainen.net/programming/tips-and-tricks/creating-restful-urls-with-spring-mvc-3-1-part-two-dispatcher-servlet-url-mappings/
 * Reference: http://stackoverflow.com/questions/13455314/spring-mvc-implementation-of-webapplicationinitializer
 * Reference: http://blog.csdn.net/uyehgdhg/article/details/17952769
 */
public class AppInitializer implements WebApplicationInitializer {

	private static boolean DBManager_Inited = false;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		/*
		AnnotationConfigWebApplicationContext webApplicationContext =
				new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(BaseAppConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		servlet.addMapping("/");
		//servlet.addMapping("*.html");
		servlet.setLoadOnStartup(1);
		//*/

		///*
		try {
			startupDataBase(servletContext);
		}
		catch (SQLException e) {
			//
		}
		//*/
	}

	public void startupDataBase(ServletContext servletContext) throws SQLException {
		System.out.println(".");
		System.out.println("========= WebApplicationInitializer::startupDataBase() enter =========");
		if (!DBManager_Inited) {
			DBManager.initDataSource(servletContext, null);
			DBManager_Inited = true;
		}
		@SuppressWarnings("unused")
		Connection conn = DBManager.getConnection();
		DBManager.closeConnection();

		System.out.println("========= WebApplicationInitializer::startupDataBase() over =========");
		System.out.println(".");
	}
}
