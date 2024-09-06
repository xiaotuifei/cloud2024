package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : tuixiaofei
 * @Date: 2024/9/6 20:09
 * @Description:
 */
@RestController
public class OrderController {

    // public static final String PaymentSrv_URL = "http://localhost:8001";

    // 服务注册中心的微服务名称
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/" + id, ResultData.class, id);
    }

//    @GetMapping(value = "/consumer/pay/delete/{id}")
//    public ResultData deleteOrder(@PathVariable("id") Integer id) {
//        return restTemplate.getForObject(PaymentSrv_URL+"/pay/delete/" + id, ResultData.class, id);
//    }
//
//    @GetMapping(value = "/consumer/pay/update")
//    public ResultData updateOrder(PayDTO payDTO) {
//        return restTemplate.put(PaymentSrv_URL+"/pay/update", payDTO);
//    }

}
