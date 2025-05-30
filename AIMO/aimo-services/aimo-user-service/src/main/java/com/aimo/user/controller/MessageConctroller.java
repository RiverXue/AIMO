package com.aimo.user.controller;

import com.aimo.user.entity.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController是Spring MVC中的注解，用于标识一个类是RESTful风格的控制器。
// 它结合了@Controller和@ResponseBody注解，使得类中的方法返回的数据将直接写入HTTP响应体中，而不是通过视图解析器进行渲染。
// 通常用于处理HTTP请求并返回JSON、XML或其他格式的数据。
@RestController
public class MessageConctroller {
    @RequestMapping("/message")
    public Message getMessage() {
        return new Message("Hello World!");
    }

}
