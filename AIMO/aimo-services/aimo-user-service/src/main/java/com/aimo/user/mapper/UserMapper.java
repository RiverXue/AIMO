package com.aimo.user.mapper;

import com.aimo.user.dto.UserDto;
import com.aimo.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
// @Mapper(componentModel = "spring")是MapStruct框架中的注解，用于生成映射器接口的实现类。
// 它告诉MapStruct框架使用Spring的依赖注入机制来创建映射器实例。
// 这个UserMapper接口将User实体对象映射为UserDto数据传输对象。
public interface UserMapper {
    // mapstruct会自动生成实现类，实现类的方法会自动调用下面的方法
    // 实现的类是UserMapperImpl，实现的方法是toDto
    // toDto方法是自动生成的，内容是：
    // @Override
    // public UserDto toDto(User user) {
    //     if ( user == null ) {
    //         return null;
    //     }
    //     UserDto userDto = new UserDto();
    //     userDto.setId( user.getId() );
    //     userDto.setUsername( user.getUsername() );
    //     return userDto;
    // }
    // 显式的指定映射的方法
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
     UserDto toDto(User user);
}
