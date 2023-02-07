package com.example.librarydb.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fine;
    private String expiry;
    @OneToOne
    @JoinColumn//By default it keeps the primary
    public Student student;
}
