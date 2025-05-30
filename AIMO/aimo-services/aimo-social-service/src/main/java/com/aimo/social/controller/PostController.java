package com.aimo.social.controller;

import com.aimo.social.entity.Post;
import com.aimo.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 加上后就会被springboot扫描到，变成一个bean
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @GetMapping("/postId/{postId}")
    public Post getPostByPostId(@PathVariable Long postId) {
        return postService.getPostByPostId(postId);
    }

    @GetMapping("/userId/{userId}")
    // 加入了@PathVariable注解，Spring会自动将URL中的userId参数绑定到方法的userId参数上
    public Post getPostByUserId(@PathVariable Long userId) {
        return postService.getPostByUserId(userId);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping
    public void updatePostByPostId(@RequestBody Post post) {
        postService.updatePostByPostId(post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
