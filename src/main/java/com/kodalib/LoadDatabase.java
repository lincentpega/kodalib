package com.kodalib;

import org.hibernate.event.spi.PreLoadEvent;
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
    CommandLineRunner initDatabase(ProductRepository productRepository, FilmRepository filmRepository) {
        return args -> {
            log.info("Preloading" + productRepository.save(Product.builder().name("Milk").price(100.5).build()));
            log.info("Preloading" + productRepository.save(Product.builder().name("Bread").price(55.43).build()));
            log.info("Preloading" + filmRepository.save(Film.builder().date(LocalDateTime.now()).title("Pulp Fiction").build()));
        };
    }
}
