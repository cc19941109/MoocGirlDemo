package com.chen.girl.controller;

import com.chen.girl.config.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    //    @Autowired 不能缺
    @Autowired
    private GirlProperties girlProperties;

    /*
    @pathVariable 获取url中的数据
    @RequestParam  获取请求参数的值
    @GetMapping  组合注解
     */

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize() + girlProperties.getAge();
    }

    @RequestMapping(value = "/speak/{id}", method = RequestMethod.GET)
    public String say1(@PathVariable("id") Integer replace) {
        //http://localhost:8080/speak/21
        return "id:" + replace;
    }

    //  @PutMapping
//  @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/speak")
    public String speak(@RequestParam(value = "key", required = false, defaultValue = "0") Integer mykey) {
        //http://localhost:8080/say?key=10
        return "key:" + mykey;
    }





}

