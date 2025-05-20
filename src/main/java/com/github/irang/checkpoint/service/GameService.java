package com.github.irang.checkpoint.service;

import com.github.irang.checkpoint.entity.Game;
import com.github.irang.checkpoint.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findByTitle(String title) {
        return gameRepository.findByTitle(title);
    }
}
