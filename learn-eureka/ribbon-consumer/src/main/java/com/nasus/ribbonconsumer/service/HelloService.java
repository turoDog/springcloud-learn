package com.nasus.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Project Name:springcloud-learn <br/>
 * Package Name:com.nasus.ribbonconsumer.service <br/>
 * Date:2020/6/18 17:16 <br/>
 *
 * @author <a href="mailto:chenzy01@eastcom-sw.com">chenzy</a><br/>
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //获取日志记录器Logger，名字为本类类名
    private static final Logger logger = LogManager.getLogger(HelloService.class);

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String hello(){
        long start = System.currentTimeMillis();
        String result =  restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time: " + (end - start));
        return result;
    }

    public String helloFallback(){
        return "error";
    }

}
