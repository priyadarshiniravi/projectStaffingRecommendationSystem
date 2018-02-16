package com.thoughtworks.services;

import com.thoughtworks.models.Project;
import com.thoughtworks.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    
    public void save(Project project) {
        projectRepository.save(project);
    }
    
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
