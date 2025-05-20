package com.github.irang.checkpoint.service;

import com.github.irang.checkpoint.entity.Review;
import com.github.irang.checkpoint.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByGame(Long gameId) {
        return reviewRepository.findByGameId(gameId);
    }
}
