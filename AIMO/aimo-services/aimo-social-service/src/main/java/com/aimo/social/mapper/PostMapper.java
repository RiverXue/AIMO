package com.aimo.social.mapper;

import com.aimo.social.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
public interface PostMapper {
    void insertPost(Post post);
    Post selectPostByPostId(Long postId);
    Post selectPostByUserId(Long userId);
    List<Post> selectAllPosts();
    void updatePostByPostId(Post post);
    void deletePostById(Long postId);
}
