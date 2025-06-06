package com.aimo.social.service.impl;

import com.aimo.social.entity.Post;
import com.aimo.social.repository.PostRepository;
import com.aimo.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postrepository;

    @Override
    public void createPost(Post post) {
        postrepository.save(post);
    }

    @Override
    public Post getPostById(String id) {
        return postrepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        return postrepository.findByUserId(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postrepository.findAll();
    }

    @Override
    public void updatePost(Post post) {
        Post existingPost = postrepository.findById(post.getId()).orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setContent(post.getContent());
        existingPost.setImageUrls(post.getImageUrls());
        existingPost.setVisibility(post.getVisibility());
        existingPost.setUpdatedAt(LocalDateTime.now());

        postrepository.save(existingPost);
    }


    @Override
    public void deletePost(String id) {
        postrepository.deleteById(id);
    }
}



//package com.aimo.social.service.impl;
//
//import com.aimo.social.entity.Post;
//import com.aimo.social.mapper.PostMapper;
//import com.aimo.social.service.PostService;
//import jakarta.annotation.Resource;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class PostServiceImpl implements PostService {
//    // Resource和Autowired都可以注入bean，但是Resource是按照名称注入的，Autowired是按照类型注入的,
//    // 所以如果有多个bean，那么Resource就会按照名称注入，Autowired就会按照类型注入。
//    // 但是如果只有一个bean，那么Resource和Autowired都可以注入。
//    // Spring Boot + MyBatis 会自动为你的 PostMapper 接口生成一个代理 Bean，名字默认就是 postMapper。
//    @Resource
//    private PostMapper postMapper;
//    @Override
//    public void createPost(Post post) {
//        postMapper.insertPost(post);
//    }
//
//    @Override
//    public Post getPostByPostId(Long postId) {
//        return postMapper.selectPostByPostId(postId);
//    }
//
//    @Override
//    public Post getPostByUserId(Long userId) {
//        return postMapper.selectPostByUserId(userId);
//    }
//
//    @Override
//    public List<Post> getAllPosts() {
//        return postMapper.selectAllPosts();
//    }
//
//    @Override
//    public void updatePostByPostId(Post post) {
//        postMapper.updatePostByPostId(post);
//    }
//
//    @Override
//    public void deletePost(Long postId) {
//        postMapper.deletePostById(postId);
//    }
//}
