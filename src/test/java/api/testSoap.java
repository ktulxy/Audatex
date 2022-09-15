package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class testSoap {
    public static void main(String args[]) throws Exception {

        String addr = "https://www-a.audatex.net/b2b/services/TaskService_v1";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:getTaskListRequest>\n" +
                "         <!--Zero or more repetitions:-->\n" +
                "         <ser:parameter xsltParameter=\"?\" context=\"?\">\n" +
                "            <ser:name>loginId</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "         </ser:parameter>\n" +
                "          <ser:parameter xsltParameter=\"?\" context=\"?\">\n" +
                "            <ser:name>password</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "         </ser:parameter>\n" +
                "\n" +
                "         <!--Optional:-->\n" +
                "         <ser:payload>?</ser:payload>\n" +
                "      </ser:getTaskListRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

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
        connection.setRequestProperty("SoapAction", "http://serviceinterface_v1.b2b.audatex.com/TaskServicePort/getTaskListRequest");
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
        String line;
             try {
                   while ((line = rd.readLine()) != null)
                System.out.println("Ответ " + line); //
                     } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
