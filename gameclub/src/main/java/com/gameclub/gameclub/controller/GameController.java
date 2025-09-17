package com.gameclub.gameclub.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gameclub.gameclub.model.Game;
import com.gameclub.gameclub.repository.GameRepository;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gameclub.gameclub.exceptions.IdNotPresentException;
import com.gameclub.gameclub.services.GameService;


@RestController
@RequestMapping(path = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) {
        Game savedGame = service.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    @GetMapping
    public ResponseEntity<List<Game>> findAll() {
        List<Game> games = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable String id) throws IdNotPresentException {
        Game game = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Game> update(@PathVariable String id, @RequestBody Game game) throws IdNotPresentException {
        Game updatedGame = service.update(id, game);
        return ResponseEntity.status(HttpStatus.OK).body(updatedGame);
    }

    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws IdNotPresentException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}