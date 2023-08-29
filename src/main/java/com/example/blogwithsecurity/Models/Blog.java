package com.example.blogwithsecurity.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "Title cannot be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String title;

    @NotEmpty(message = "Body cannot be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String body;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

}
