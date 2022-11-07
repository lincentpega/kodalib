package com.kodalib.exceprions;

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(Integer filmId) {
        super("Could not find film " + filmId);
    }
}
