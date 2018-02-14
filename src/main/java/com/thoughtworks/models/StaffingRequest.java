package com.thoughtworks.models;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class StaffingRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade=CascadeType.ALL)
    Project project;
    
    @Enumerated
    Role role;
    
    @ManyToOne(cascade=CascadeType.ALL)
    Account account;
    
    @Enumerated
    Grade grade;
    
    @Enumerated
    Location location;
}
