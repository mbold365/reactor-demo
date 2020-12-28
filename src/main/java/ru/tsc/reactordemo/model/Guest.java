package ru.tsc.reactordemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("guests")
public class Guest {

    @Id
    private Long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column
    private String patronymic;

    @Column
    private String email;

    @Column("visit_date")
    private Date visitDate;
}
