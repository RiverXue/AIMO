package com.aimo.social.repository;

import com.aimo.social.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    // mongodb的repository里没有，所以要自己写一个方法，根据userId查询post
    // mongodb的repository里有: findById, findAll, save, deleteById, deleteAll
    List<Post> findByUserId(Long userId);


    List<Post> id(String id);
}
