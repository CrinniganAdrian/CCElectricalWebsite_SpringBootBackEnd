package com.bezkoder.springjwt.controllerTests;

import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProjectsConTest {


    @Autowired
    ProjectRepository projectRepository;


    @Test
    public void testCreateReadDelete() {
        Project project = new Project("TestProject", "Neighbors House","www.house.com");

        Project projectResult = projectRepository.save(project);

        Iterable<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects).last().hasFieldOrPropertyWithValue("name", "TestProject");

        projectRepository.delete(projectResult);
        Assertions.assertThat(projects).doesNotContain(project);
    }

}
