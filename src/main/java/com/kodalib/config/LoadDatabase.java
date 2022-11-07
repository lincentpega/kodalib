package com.kodalib.config;

import com.kodalib.model.Film;
import com.kodalib.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase( FilmRepository filmRepository) {
        return args -> {
            log.info("Preloading" + filmRepository.save(Film.builder().id(1).title("TestFilm1").dateCreateNote(LocalDateTime.now()).build()));
            log.info("Preloading" + filmRepository.save(new Film("Pulp Fiction")));
        };
    }
}
