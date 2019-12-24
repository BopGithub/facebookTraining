package com.facebook.training.facebook.controller;

import com.facebook.training.facebook.exceptions.PostNotFoundException;
import com.facebook.training.facebook.model.Post;
import com.facebook.training.facebook.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    public PostRepository postRepository;

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable(name = "id") Long postId, @Valid @RequestBody Post req) throws PostNotFoundException {
    return postRepository.findById(postId).map(post-> {
        post.setTitle(req.getTitle());
        post.setDescription(req.getDescription());
        return postRepository.save(post);
    }).orElseThrow(() ->new PostNotFoundException("PostId" + postId + " not found"));

    }
}
