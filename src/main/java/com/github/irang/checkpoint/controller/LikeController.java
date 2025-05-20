package com.github.irang.checkpoint.controller;

import com.github.irang.checkpoint.entity.Like;
import com.github.irang.checkpoint.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> create(@RequestBody Like like) {
        return ResponseEntity.ok(likeService.save(like));
    }

    @GetMapping
    public ResponseEntity<Boolean> checkLike(@RequestParam Long userId, @RequestParam Long reviewId) {
        return ResponseEntity.ok(likeService.isLiked(userId, reviewId));
    }
}
