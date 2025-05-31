package com.aimo.social.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private Long userId;
    private String content;
    private List<String> imageUrls;
    private String visibility = "PUBLIC";
    private Integer likeCount = 0;
    private Integer commentCount = 0;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    private List<Comment> comments;

    @Data
    // 评论
    public static class Comment {
        private String commentId;
        private Long commenterId;
        private String content;
        private Integer likeCount = 0;
        private LocalDateTime createdAt = LocalDateTime.now();

        private List<Reply> replies;
        @Data
        // 评论的回复
        public static class Reply {
            private String replyId;
            private Long replyUserId;
            private String content;
            private LocalDateTime createdAt = LocalDateTime.now();
        }
    }
    // 新增字段, 用于存储点赞和收藏的用户ID列表
    private List<Long> likedUserIds;
    private List<Long> favoritedUserIds;
}
