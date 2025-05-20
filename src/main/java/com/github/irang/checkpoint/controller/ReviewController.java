package com.github.irang.checkpoint.controller;

import com.github.irang.checkpoint.entity.Review;
import com.github.irang.checkpoint.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.save(review));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Review>> getByGame(@PathVariable Long gameId) {
        return ResponseEntity.ok(reviewService.getReviewsByGame(gameId));
    }
}
