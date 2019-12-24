package com.facebook.training.facebook.controller;


import com.facebook.training.facebook.exceptions.CommentNotFoundException;
import com.facebook.training.facebook.model.Comment;
import com.facebook.training.facebook.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    public CommentRepository commentRepository;

    @PutMapping("/comment/{id}")
    public Comment updateComment(@PathVariable(name = "id") Long commentId, @Valid @RequestBody Comment req) throws CommentNotFoundException {
        return commentRepository.findById(commentId).map(comment-> {
            comment.setText(req.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() ->new CommentNotFoundException("PostId" + commentId + " not found"));

    }
}
