package com.kodalib.controller;

import com.kodalib.exceprions.FilmNotFoundException;
import com.kodalib.repository.FilmRepository;
import com.kodalib.model.Film;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(
            FilmRepository filmRepository) {

        this.filmRepository = filmRepository;
    }

    @GetMapping("/film")
    Iterable<Film> allFilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/film/{id}")
    Film getFilm(@PathVariable Integer id) {
        return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    @PostMapping("/film")
    Film newFilm(@RequestBody Film newFilm) {
        return filmRepository.save(newFilm);
    }
}
