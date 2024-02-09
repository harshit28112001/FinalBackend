package com.blogs.login;
import com.blogs.login.filter.filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		System.out.println("Running Authentication.......");
	}
	@Bean
	public FilterRegistrationBean getFilter(){
		FilterRegistrationBean filterReg= new FilterRegistrationBean();
		filterReg.setFilter(new filter());
		filterReg.addUrlPatterns("/auth/getAll");
		return filterReg;
	}
	@Configuration
	public class CorsConfiguration implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("http://loginharshit.itcblogs.xyz")
					.allowedMethods("GET", "POST", "PUT", "DELETE");
		}

	}


}
