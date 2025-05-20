package com.github.irang.checkpoint.service;

import com.github.irang.checkpoint.entity.Comment;
import com.github.irang.checkpoint.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getByReview(Long reviewId) {
        return commentRepository.findByReviewId(reviewId);
    }
}
