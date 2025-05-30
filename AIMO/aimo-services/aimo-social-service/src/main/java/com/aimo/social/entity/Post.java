package com.aimo.social.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity // 加上后就会被springboot扫描到，变成一个bean
public class Post {
    @Id
    private Long postId;
    private Long userId;
    private String content;
    private String imageUrls;
    private String visibility;
    private Integer likeCount;
    private Integer commentCount;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
}
