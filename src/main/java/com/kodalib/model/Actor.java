package com.kodalib.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "actors")
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false, unique = true)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @ManyToMany(mappedBy = "actors")
    private Collection<Film> films;
}
