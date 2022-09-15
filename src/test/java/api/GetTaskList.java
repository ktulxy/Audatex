package api;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.PKGetTaskList.getTask;

public class GetTaskList {

    @Test
    public void getTaskList() throws Exception {
       // getTask(); А нужно так? получается вызывает два раза тут и в асертах один и тот метод
        Assert.assertEquals(getTask(), "Operation terminated successfully");
    }
}
