package cloud.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private static Logger logger =LoggerFactory.getLogger(TestController.class);
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/hello/neo")
    @ResponseBody// 请求此处融断以后  在url中输入http://localhost:7079/hystrix.stream 能够看到json信息
    //在 http://localhost:7079/hystrix  的框中访问http://localhost:7079/hystrix.stream 可以看到图表
    public String testHystrix(){
        logger.info("进入绒缎");
        return consumerService.hystrix();
    }
}
