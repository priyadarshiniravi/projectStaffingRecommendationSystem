package com.thoughtworks.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class StaffingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    Project project;
    
    @Enumerated
    Role role;
    
    @Enumerated
    Grade grade;
    
    @Enumerated
    Location location;
    
    @ElementCollection
    List<String> skillSet;
}
