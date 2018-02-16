package com.thoughtworks.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    Account account;
    
    private String name;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startDate;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate endDate;
    
    private int probablity;
}
