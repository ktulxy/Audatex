package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static data.PKCreateTask.createTaskPk;

public class CreateTask {

    @Test
    public void createTask() throws Exception{

        Assert.assertEquals(createTaskPk(),"Operation terminated successfully");
    }
}
