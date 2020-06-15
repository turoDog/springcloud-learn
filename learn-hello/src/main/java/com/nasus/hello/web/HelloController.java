package com.nasus.hello.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:sclearn <br/>
 * Package Name:com.nasus.sclearn.web <br/>
 * Date:2020/6/15 13:03 <br/>
 *
 * @author <a href="mailto:chenzy01@eastcom-sw.com">chenzy</a><br/>
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index(){

        return "Hello World!";

    }

}
