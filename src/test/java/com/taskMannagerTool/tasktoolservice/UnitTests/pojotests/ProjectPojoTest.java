package com.taskMannagerTool.tasktoolservice.UnitTests.pojotests;

import com.taskMannagerTool.tasktoolservice.models.Project;
import com.taskMannagerTool.tasktoolservice.models.State;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class ProjectPojoTest {


    @Test
    public void createProject(){

        Project project = new Project();

        project.setProjectName("TASK TOOL");
        project.setProjectDescription("A small project for task management");
        project.setProjectState(State.IN_PROGRESS);



        Assert.assertEquals(project.getProjectName(),"TASK TOOL");
        Assert.assertThat(project.getProjectName(), Matchers.equalToIgnoringCase("TASK TOOL"));

        Assert.assertEquals(project.getProjectDescription(),"A small project for task management");
        Assert.assertThat(project.getProjectDescription(),Matchers.equalToIgnoringCase("A small project for task management"));

        Assert.assertEquals(project.getProjectState(),State.IN_PROGRESS);
        Assert.assertThat(project.getProjectState(),Matchers.equalTo(State.IN_PROGRESS));

    }
}
