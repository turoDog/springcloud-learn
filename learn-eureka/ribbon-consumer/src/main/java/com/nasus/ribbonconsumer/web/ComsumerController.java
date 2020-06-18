package com.nasus.ribbonconsumer.web;

import com.nasus.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Project Name:springcloud-learn <br/>
 * Package Name:com.nasus.ribbonconsumer.web <br/>
 * Date:2020/6/16 17:10 <br/>
 *
 * @author <a href="mailto:chenzy01@eastcom-sw.com">chenzy</a><br/>
 */
@RestController
public class ComsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

}
