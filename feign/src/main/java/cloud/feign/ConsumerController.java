package cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public Integer sub() {
        logger.info("进入");
        return computeClient.sub(10, 20);
    }

}