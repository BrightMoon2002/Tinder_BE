package com.codegym.model.user;

import lombok.Data;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name = "avatars")
@Data
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne(targetEntity = Staff.class)
    private Staff staff;






}
