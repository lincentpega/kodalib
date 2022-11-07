package com.kodalib;

import com.kodalib.model.Film;
import com.kodalib.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    private final FilmRepository filmRepository;
    private final ProductRepository productRepository;

    public FilmController(FilmRepository filmRepository, ProductRepository productRepository) {
        this.filmRepository = filmRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> allProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/films")
    List<Film> allFilms() {
        return filmRepository.findAll();
    }
}
