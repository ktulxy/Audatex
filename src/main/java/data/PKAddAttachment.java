package data;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PKAddAttachment {



    public static String addAttachmentPK() throws Exception {

        String addr = "https://www-a.audatex.net/b2b/services/AttachmentService_v1";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "    <ser:addAttachmentsToTaskRequest xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>loginId</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>password</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>taskId</ser:name>\n" +
                "            <ser:value>6FA2E624-F8A5-5666-FAB4-8344524822F9</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:payload>\n" +
                "            <AttachmentBinaryList xmlns=\"http://intrasystems.com.ua/Audatex-REST\">\n" +
                "                <AttachmentBinary>\n" +
                "                    <Status>Check</Status>\n" +
                "                    <Category>OWNER</Category>\n" +
                "                    <FileName>Passport.txt</FileName>\n" +
                "                    <Source>\n" +
                "                        <Attachment>4PPk4PLl6vE=</Attachment>\n" +
                "                    </Source>\n" +
                "                </AttachmentBinary>\n" +
                "                <AttachmentBinary>\n" +
                "                    <Status>Check</Status>\n" +
                "                    <Category>OTHER</Category>\n" +
                "                    <FileName>DriverLicence.txt</FileName>\n" +
                "                    <Source>\n" +
                "                        <Attachment>4PPk4PLl6vE=</Attachment>\n" +
                "                    </Source>\n" +
                "                </AttachmentBinary>\n" +
                "            </AttachmentBinaryList>\n" +
                "        </ser:payload>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>returnPayloadAsXML</ser:name>\n" +
                "            <ser:value>true</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>responseStylesheet</ser:name>\n" +
                "            <ser:value>uains.xslt</ser:value>\n" +
                "        </ser:parameter>\n" +
                "    </ser:addAttachmentsToTaskRequest>\n" +
                " </soapenv:Body>\\n\" +\n" +
                "  \"</soapenv:Envelope>";

        URL url = null;
        try {
            url = new URL(addr);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        connection.setRequestProperty("Content-Length", String.valueOf(request.length()));
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("SoapAction", "http://serviceinterface_v1.b2b.audatex.com/AttachmentServicePort/addAttachmentsToTaskRequest");
        connection.setDoOutput(true);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(connection.getOutputStream());
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        pw.write(request);
        pw.flush();

        try {
            connection.connect();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String line=rd.readLine();
      //   System.out.println("Otvet 1 " + line);
        String resultAdd = line.substring(line.indexOf("text") + 5, line.indexOf("/text") -1);
        return resultAdd;
        //Assert.assertEquals(resultStr, "Operation terminated successfully");
       /*
           String linea;
            try {
                   while ((linea = rd.readLine()) != null)
                System.out.println("Ответ " + linea);
                     } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/
    }
}
