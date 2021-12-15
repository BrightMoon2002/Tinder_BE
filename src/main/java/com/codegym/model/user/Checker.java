package com.codegym.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "checkers")
@Data
public class Checker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
