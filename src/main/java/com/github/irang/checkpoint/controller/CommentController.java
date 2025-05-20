package com.github.irang.checkpoint.controller;

import com.github.irang.checkpoint.entity.Comment;
import com.github.irang.checkpoint.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.save(comment));
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<List<Comment>> getByReview(@PathVariable Long reviewId) {
        return ResponseEntity.ok(commentService.getByReview(reviewId));
    }
}
