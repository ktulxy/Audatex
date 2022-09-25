package api;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.PKGetTaskList.getTask;

public class GetTaskList {

    @Test
    public void getTaskList() throws Exception {

        Assert.assertEquals(getTask(), "Operation terminated successfully");
    }
}
