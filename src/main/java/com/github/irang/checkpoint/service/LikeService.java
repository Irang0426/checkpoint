package com.github.irang.checkpoint.service;

import com.github.irang.checkpoint.entity.Like;
import com.github.irang.checkpoint.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public Like save(Like like) {
        return likeRepository.save(like);
    }

    public boolean isLiked(Long userId, Long reviewId) {
        return likeRepository.existsByUserIdAndReviewId(userId, reviewId);
    }
}
