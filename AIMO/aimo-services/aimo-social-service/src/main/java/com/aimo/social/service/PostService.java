package com.aimo.social.service;

import com.aimo.social.entity.Post;

import java.util.List;

public interface PostService {
    void createPost(Post post);
    Post getPostById(String id);
    List<Post> getPostByUserId(Long userId);
    List<Post> getAllPosts();
    void updatePost(Post post);
    //    void updatePostByPostId(Post post);
    void deletePost(String postId);
}
