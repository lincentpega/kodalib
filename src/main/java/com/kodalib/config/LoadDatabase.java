package com.kodalib.config;

import com.kodalib.model.Country;
import com.kodalib.model.Film;
import com.kodalib.repository.CountryRepository;
import com.kodalib.repository.FilmRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Log4j2
@Configuration
public class LoadDatabase {

    private static FilmRepository filmRepository;
    private static CountryRepository countryRepository;

    @Bean
    CommandLineRunner initDatabase(FilmRepository filmRepository) {
        return args -> {
            var countries = new ArrayList<Country>();
            countries.add(new Country(null, "USA", null));
            log.info("Preloading" + filmRepository.save(
                    Film.builder().title("Pulp Fiction").year((short) 1994).countries(countries).build()));
//            countryRepository.save(new Country())
        };
    }
}
