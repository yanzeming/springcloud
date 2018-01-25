package cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("compute-service")//此处被注册到服务，客户端调用的时候会自动轮询，不需要指定实现该服务的主机
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sub")
    default Integer sub(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b){
        return a+b;
    };

}