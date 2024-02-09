package com.blogs.dashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class DashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
		System.out.println("DashBoard running......");
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

