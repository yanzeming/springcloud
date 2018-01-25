package cloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrix() {
        return restTemplate.getForObject("http://service-B/hystrix", String.class);
    }

    public String fallback() {
        return "fallback    远程调用故障，其余处理  服务降级";
    }

}