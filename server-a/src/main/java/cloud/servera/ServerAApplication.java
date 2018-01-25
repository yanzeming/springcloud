package cloud.servera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerAApplication.class, args);
	}
}
