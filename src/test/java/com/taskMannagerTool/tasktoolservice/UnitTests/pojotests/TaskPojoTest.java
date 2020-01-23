package com.taskMannagerTool.tasktoolservice.UnitTests.pojotests;

import com.taskMannagerTool.tasktoolservice.models.Priority;
import com.taskMannagerTool.tasktoolservice.models.State;
import com.taskMannagerTool.tasktoolservice.models.Task;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskPojoTest {

    @Test
    public void createTask(){
        Task task = new Task();

        task.setStartDate(new Date());
        task.setDueDate(new Date());
        task.setTaskTitle("Create Test for our project");
        task.setTaskDescription("WE have to create test for all of our POJO,SERVICES,CONTROLLERS");
        task.setTaskPriority(Priority.MAJOR);
        task.setTaskState(State.IN_PROGRESS);

        Assert.assertEquals(task.getStartDate().toString(),new Date().toString());
        Assert.assertThat(task.getStartDate().toString(), Matchers.equalToIgnoringCase(new Date().toString()));

        Assert.assertEquals(task.getDueDate().toString(),new Date().toString());
        Assert.assertThat(task.getDueDate().toString(),Matchers.equalToIgnoringCase(new Date().toString()));

        Assert.assertEquals(task.getTaskTitle(),"Create Test for our project");
        Assert.assertThat(task.getTaskTitle(),Matchers.equalToIgnoringCase("Create Test for our project"));

        Assert.assertEquals(task.getTaskDescription(),"WE have to create test for all of our POJO,SERVICES,CONTROLLERS");
        Assert.assertThat(task.getTaskDescription(),Matchers.equalToIgnoringCase("WE have to create test for all of our POJO,SERVICES,CONTROLLERS"));

        Assert.assertEquals(task.getTaskPriority(),Priority.MAJOR);
        Assert.assertThat(task.getTaskPriority(),Matchers.equalTo(Priority.MAJOR));

        Assert.assertEquals(task.getTaskState(),State.IN_PROGRESS);
        Assert.assertThat(task.getTaskState(),Matchers.equalTo(State.IN_PROGRESS));



    }


}
