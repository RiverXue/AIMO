package com.aimo.user.Repository;

import com.aimo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findAll();

    // 以下是MyBatis的示例，通常MyBatis会使用Mapper接口和XML文件或注解来实现
    // @Mapper // 通常MyBatis的Mapper接口会加上@Mapper注解
    // public interface UserMapper {
    //     // 使用注解方式定义SQL
    //     // @Select("SELECT * FROM users WHERE username = #{username}")
    //     // Optional<User> findByUsernameMyBatis(@Param("username") String username);
    //
    //     // 使用XML方式定义SQL (假设对应的XML文件中有id为insertUser的SQL)
    //     // int insertUser(User user);
    // }
}
