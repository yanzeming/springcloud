package cloud.serverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerBApplication.class, args);
	}
}
