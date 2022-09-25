package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static data.PKAddAttachment.addAttachmentPK;

public class AddAttachment {

    @Test
    public void AddAttachment() throws Exception {

        Assert.assertEquals(addAttachmentPK(),"Operation terminated successfully");
    }
}
