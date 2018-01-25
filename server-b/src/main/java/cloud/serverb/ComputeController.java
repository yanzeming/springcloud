package cloud.serverb;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/sub" ,method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a - b;
        logger.info("/sub, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-B, Result is " + r+" \nPort:"+instance.getPort();
    }

    //call service-A
    @RequestMapping(value="testServiceA",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
    	RestTemplate restTemplate=new RestTemplate();
    	return restTemplate.getForObject("http://localhost:2222/add?a="+a+"&b="+b, String.class);
    }

    @RequestMapping(value ="/hystrix")
    public String hystrix(){
        logger.info("模拟熔断处理，  自动延时");
        try {
            Thread.sleep(5000L);//延时模拟阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "熔断";
    }
}