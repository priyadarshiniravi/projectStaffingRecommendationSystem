package com.thoughtworks.controllers;

import com.thoughtworks.models.Project;
import com.thoughtworks.services.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {
    @Mock
    private ProjectService projectService;
    
    private ProjectController projectController;
    
    @Mock
    private Project project;
    
    @Before
    public void setUp() throws Exception {
        projectController = new ProjectController(projectService);
    }
    
    @Test
    public void shouldGetAllTheProjects() throws Exception {
        when(projectService.getAll()).thenReturn(Collections.singletonList(project));
    
        ResponseEntity responseEntity = projectController.getAll();
        List<Project> projects = (List<Project>) responseEntity.getBody();
    
        assertThat(projects.get(0)).isEqualTo(project);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }
    
    @Test
    public void shouldSaveProject() throws Exception {
        doNothing().when(projectService).save(project);
    
        ResponseEntity responseEntity = projectController.save(project);
    
        verify(projectService).save(project);
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
    }
}