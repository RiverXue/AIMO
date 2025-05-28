package com.aimo.user.controller;

import com.aimo.user.dto.LoginRequest;
import com.aimo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    // 注册用户
    @RequestMapping("/register")
    public String registerUser(@RequestBody LoginRequest loginRequest) {
        return userService.registerUser(loginRequest.getUsername(), loginRequest.getPassword());
    }


    // 登录用户
    @RequestMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword())
                .map(user -> ResponseEntity.ok("登录成功。" + user.getUsername()))
                .orElse(ResponseEntity.status(401).body("登录失败，用户或密码错误。"));
    }
}
