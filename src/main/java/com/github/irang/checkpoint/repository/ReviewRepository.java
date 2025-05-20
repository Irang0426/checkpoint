package com.github.irang.checkpoint.repository;

import com.github.irang.checkpoint.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByGameId(Long gameId);
}
