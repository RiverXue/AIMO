package com.aimo.user.controller;

import com.aimo.common.util.JwtUtils;
import com.aimo.user.Repository.UserRepository;
import com.aimo.user.dto.LoginRequest;
import com.aimo.user.dto.UserDto;
import com.aimo.user.entity.User;
import com.aimo.user.mapper.UserMapper;
import com.aimo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Riv");
        return "index";
    }

    @RequestMapping("/users")
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
//               .map(user -> new UserDto(user.getId(), user.getUsername()))
//               .toList();
                // 这个表达式是一个Lambda表达式，用于将User对象转换为UserDto对象
                // lambda表达式的语法是：(参数列表) -> { 表达式或语句块 }
                // (::)是方法引用操作符，用于引用一个方法
                // 方法引用的语法是：类名::方法名
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @RequestMapping("users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        // @PathVariable在此处用于从URL路径中获取id参数的值
        // orElse(null)用于处理可能的空值情况，避免抛出异常
        // 新建一个User对象，用于存储从数据库中查询到的用户信息
        // 如果查询到的用户信息为空，则返回一个404 Not Found的响应
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            // ResponseEntity是Spring MVC中用于封装HTTP响应的类，它可以包含响应状态码、响应头和响应体
            return ResponseEntity.notFound().build();
        }
        // var一个userDto对象，用于存储从数据库中查询到的用户信息
//        var userDto = new UserDto(user.getId(), user.getUsername());
//        return ResponseEntity.ok(userDto);
        // 可以直接返回UserDto对象，因为UserDto类已经实现了Serializable接口
        return ResponseEntity.ok(userMapper.toDto(user));
    }


    // 注册用户
    @RequestMapping("/register")
    public String registerUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("收到注册请求" + loginRequest.getUsername());
        return userService.registerUser(loginRequest.getUsername(), loginRequest.getPassword());
    }


    // 登录用户
    @RequestMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword())
                .map(user -> {
                    System.out.println("用户ID: " + user.getId());
                    System.out.println("用户名: " + user.getUsername());
                    // 登录成功，生成token
                    String token = JwtUtils.createToken(
                            String.valueOf(user.getId()),
                            user.getUsername()
                    );
                    return ResponseEntity.ok(token);
                })
                .orElse(ResponseEntity.status(401).body("登录失败，用户或密码错误。"));
    }

    @RequestMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        // 获取当前登录用户的认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }

        // 获取用户名（前面生成 token 时用的用户名）
        String username = authentication.getName();

        // 根据用户名查询用户
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }

}
