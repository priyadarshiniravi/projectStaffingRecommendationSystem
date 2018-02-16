package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.Project;
import com.thoughtworks.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoints.PROJECT)
public class ProjectController {
    private final ProjectService projectService;
    
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    @PostMapping
    public ResponseEntity save(@Validated @RequestBody Project project) {
        projectService.save(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping
    public ResponseEntity getAll() {
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
