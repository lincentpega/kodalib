package com.kodalib.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

@Entity
@Table(name = "films")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;

    @Column(name = "duration_minutes")
    private Integer duration;

    @Column(name = "year")
    private Short year;

    @Column(name = "cash_success")
    private Integer cashSuccess;

    @Column(name = "date_creation", nullable = false)
    @CreationTimestamp
    private Instant dateCreation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "films_actors",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Collection<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "films_countries",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Collection<Country> countries;
}