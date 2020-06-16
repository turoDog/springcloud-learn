package com.nasus.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project Name:sclearn <br/>
 * Package Name:com.nasus.sclearn.web <br/>
 * Date:2020/6/15 13:03 <br/>
 *
 * @author <a href="mailto:chenzy01@eastcom-sw.com">chenzy</a><br/>
 */
@RestController
public class HelloController {

    // 服务注册
    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index(){
        ServiceInstance instance = serviceInstance();
        String x = String.format("Host: %s, ServiceId: %s\n", instance.getHost(), instance.getServiceId());
        System.out.println(x);
        return "Hello World!";

    }


    /**
     * 获取当前服务实例
     * @return
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 8888)
                    return itm;
            }
        }
        return null;
    }
}
