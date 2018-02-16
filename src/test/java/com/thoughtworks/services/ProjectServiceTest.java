package com.thoughtworks.services;

import com.thoughtworks.models.Project;
import com.thoughtworks.repositories.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;
    
    private ProjectService projectService;
    
    @Mock
    private Project project;
    
    @Before
    public void setUp() throws Exception {
        projectService = new ProjectService(projectRepository);
    }
    
    @Test
    public void shouldSaveProjectIntoRepository() throws Exception {
        projectService.save(project);
        
        verify(projectRepository).save(project);
    }
    
    @Test
    public void shouldFindAllFromRepository() throws Exception {
        projectService.getAll();
        
        verify(projectRepository).findAll();
    }
}