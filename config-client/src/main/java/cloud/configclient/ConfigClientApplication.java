package cloud.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@EnableDiscoveryClient//追踪发现
@SpringBootApplication
public class ConfigClientApplication {
	private Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@Value("${name}")
	String name;

	@Value("${before}")
	String before;

	@Value("${after}")
	String after;

	@RequestMapping(value = "/hi")
	public String hi(){
		logger.info("进入");
		return foo;
	}
	@RequestMapping(value = "/after")
	public String after(){
		return after;
	}
	@RequestMapping(value = "/name")
	public String name(){
		return name;
	}
	@RequestMapping(value = "/before")
	public String before(){
		return before;
	}
}
