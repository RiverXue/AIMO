package com.aimo.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Data;
@Entity // 声明这是一个JPA实体，对应数据库中的一张表
@Table(name = "users") // 指定实体映射到的数据库表名为"users"
@Data // Lombok注解，自动生成getter/setter、equals、hashCode、toString方法
public class User {
    @Id // 声明id字段是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，IDENTITY表示由数据库自动递增
    private Long id;
    @Column(unique = true, nullable = false) // 声明username字段映射到数据库列，且是唯一且非空的
    private String username;

    private String password;
}
