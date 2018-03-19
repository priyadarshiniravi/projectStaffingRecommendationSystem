package com.thoughtworks.Filter;

import com.thoughtworks.models.Project;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterListTest {
    
    @Test
    public void shouldFilterListBasedOnGivenCriteria() throws Exception {
        ArrayList<Project> projects = new ArrayList<>();
        Project project = mock(Project.class);
        when(project.getName()).thenReturn("Proj");
        Project project1 = mock(Project.class);
        when(project1.getName()).thenReturn("Proj 1");
        Project project2 = mock(Project.class);
        when(project2.getName()).thenReturn("Proj 2");
        Project project3 = mock(Project.class);
        when(project3.getName()).thenReturn("Proj 3");
        Project project4 = mock(Project.class);
        when(project4.getName()).thenReturn("fell Proj 4");
        projects.addAll(asList(project, project1, project2, project3, project4));
        
        Filter<Project, Object> filter = (object, criteria) -> object.getName().startsWith(String.valueOf(criteria[0]));
        
        List filteredProjects = new FilterList().filterList(projects, filter, "Proj");
        
        assertThat(filteredProjects).containsExactly(project, project1, project2, project3);
    }
}