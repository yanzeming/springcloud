package cloud.zuulroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulrouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulrouteApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
