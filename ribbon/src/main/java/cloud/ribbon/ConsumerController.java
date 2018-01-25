package cloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;
    @GetMapping("/hystrix")//熔断处理
    public String hystrix() {
        return consumerService.hystrix();
    }


    @Autowired  
    private LoadBalancerClient loadBalancerClient;  

    @RequestMapping(value = "/sub", method = RequestMethod.GET)//此处单纯演示负载均衡，不考虑熔断
    public String sub(@RequestParam Integer a,@RequestParam Integer b) {
    	this.loadBalancerClient.choose("service-B");
        return restTemplate.getForEntity("http://service-B/sub?a="+a+"&b="+b, String.class).getBody();
    	//此处手动指定处理该服务的主机,服务端负载均衡
    }



}