package com.aimo.diary.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
// @TableName("diary")，表示该类对应的数据库表名为 "diary"。
// 这样，在使用 MyBatis-Plus 进行数据库操作时，会自动将该类的属性映射到对应的数据库表字段上。
@TableName("diary")
public class Diary {
    private Long id;
    private String userId;
    private String title;
    private String content;
    @TableField(fill = FieldFill.INSERT) // 插入时自动填充
    private LocalDateTime createTime;
    // @TableField(fill = FieldFill.INSERT_UPDATE)，表示该字段在插入和更新时都会被自动填充。
    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时自动填充
    private LocalDateTime updateTime;
}
