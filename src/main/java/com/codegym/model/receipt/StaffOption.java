package com.codegym.model.receipt;

import com.codegym.model.user.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "staffOptions")
@Data
@NoArgsConstructor
public class StaffOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Staff.class)

    private Staff staff;

    @ManyToOne(targetEntity = Option.class)

    private Option option;

}
