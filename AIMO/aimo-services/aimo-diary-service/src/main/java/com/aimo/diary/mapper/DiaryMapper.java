package com.aimo.diary.mapper;

import com.aimo.diary.entity.Diary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 标记为 MyBatis 的 Mapper 接口，用于与数据库进行交互。
// 该接口继承了 BaseMapper 接口，提供了基本的 CRUD 操作方法，如 insert、update、delete、selectById 等。
// <Diary> 表示该 Mapper 接口操作的实体类为 Diary。
public interface DiaryMapper extends BaseMapper<Diary> {
}
