package dev.djigit99.chesswebsitebackend.controllers;

import dev.djigit99.chesswebsitebackend.models.News;
import dev.djigit99.chesswebsitebackend.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(newsRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getNewsById(@PathVariable("id") Integer id) {
        News news = newsRepository.findNewsById(id);

        if (news == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Новина не знайдена.");
        }

        return ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<?> addNews(@Valid @RequestBody News news) {
        News addedNews = newsRepository.save(news);
        return ResponseEntity.ok().body(addedNews);
    }

}
