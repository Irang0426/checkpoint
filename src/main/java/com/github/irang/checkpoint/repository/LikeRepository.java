package com.github.irang.checkpoint.repository;

import com.github.irang.checkpoint.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserIdAndReviewId(Long userId, Long reviewId);
}
