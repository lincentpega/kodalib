package com.kodalib;

import com.kodalib.model.Film;
import com.kodalib.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, FilmRepository filmRepository) {
        return args -> {
            log.info("Preloading" + productRepository.save(Product.builder().id(1L).name("Milk").price(100.5).build()));
            log.info("Preloading" + productRepository.save(Product.builder().id(2L).name("Bread").price(55.43).build()));
            log.info("Preloading" + filmRepository.save(Film.builder().id(1).dateCreateNote(OffsetDateTime.now()).title("Pulp Fiction").build()));
        };
    }
}
