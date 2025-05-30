package com.aimo.social.service;

import com.aimo.social.entity.Post;

import java.util.List;

public interface PostService {
    void createPost(Post post);
    Post getPostByPostId(Long postId);
    Post getPostByUserId(Long userId);
    List<Post> getAllPosts();
    void updatePostByPostId(Post post);
    void deletePost(Long postId);
}
