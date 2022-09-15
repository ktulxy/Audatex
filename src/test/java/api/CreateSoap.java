package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CreateSoap {

    public static void main(String args[]) throws Exception {
        String addr = "https://www-a.audatex.net/b2b/services/TaskService_v1";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "    <ser:createTaskRequest xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>loginId</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>password</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>processAsUser</ser:name>\n" +
                "            <ser:value>ingo.b2b</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>identifyVehicle</ser:name>\n" +
                "            <ser:value>true</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:parameter>\n" +
                "            <ser:name>responseStylesheet</ser:name>\n" +
                "            <ser:value>uains.xslt</ser:value>\n" +
                "        </ser:parameter>\n" +
                "        <ser:payload>\n" +
                "            <Task xmlns=\"http://intrasystems.com.ua/Audatex-REST\">\n" +
                "                <ClaimNumber>ClaimNumber№</ClaimNumber>\n" +
                "                <Versions>\n" +
                "                    <GeneratorVersion>INGO.AIS.05.10.2016</GeneratorVersion>\n" +
                "                    <Generator>GENCODE000191</Generator>\n" +
                "                </Versions>\n" +
                "                <Inspection>\n" +
                "                    <OtherInspectionTypeText>OWNER,INVOICE</OtherInspectionTypeText>\n" +
                "                </Inspection>\n" +
                "                <BasicClaimData>\n" +
                "                    <Vehicle>\n" +
                "                        <VehicleIdentification>\n" +
                "                            <ManufacturerName>MINI</ManufacturerName>\n" +
                "                            <ModelName>Cooper</ModelName>\n" +
                "                            <ManufacturerCodeAX>19</ManufacturerCodeAX>\n" +
                "                            <ModelCodeAX>31</ModelCodeAX>\n" +
                "                            <VIN>WMWXM510203A24295</VIN>\n" +
                "                        </VehicleIdentification>\n" +
                "                        <VehicleAdmin>\n" +
                "                            <PlateNumber>AA0000AA</PlateNumber>\n" +
                "                            <AcquisitionDate>2012-06-16</AcquisitionDate>\n" +
                "                            <VehicleOwner>\n" +
                "                                <CompanyName>If Owner is company</CompanyName>\n" +
                "                                <CommunicationDetailList>\n" +
                "                                    <CommunicationDetail>\n" +
                "                                        <Role>Phone1</Role>\n" +
                "                                        <Entry>632114416</Entry>\n" +
                "                                    </CommunicationDetail>\n" +
                "                                    <CommunicationDetail>\n" +
                "                                        <Role>EMail1</Role>\n" +
                "                                        <Entry>omudritsky@gmail.com</Entry>\n" +
                "                                    </CommunicationDetail>\n" +
                "                                </CommunicationDetailList>\n" +
                "                                <LicenseNumber>1234</LicenseNumber>\n" +
                "                                <FirstName>Олег</FirstName>\n" +
                "                                <LastName>Тестович</LastName>\n" +
                "                                <AddressList>\n" +
                "                                    <Address>\n" +
                "                                        <ZipCode>05120</ZipCode>\n" +
                "                                        <Country>UА</Country>\n" +
                "                                        <City>Киев</City>\n" +
                "                                        <Line2>Дорогожицькая 3</Line2>\n" +
                "                                    </Address>\n" +
                "                                </AddressList>\n" +
                "                            </VehicleOwner>\n" +
                "                            <FirstRegistrationDate>2017-02-01T00: 00: 00</FirstRegistrationDate>\n" +
                "                        </VehicleAdmin>\n" +
                "                        <VehicleEngineering>\n" +
                "                            <BodyTypeText>Хетчбек</BodyTypeText>\n" +
                "                            <EngineId>5950P6</EngineId>\n" +
                "                            <EngineSize>1800</EngineSize>\n" +
                "                            <Color>жовтий/yellow</Color>\n" +
                "                            <Mileage>100000</Mileage>\n" +
                "                            <EngineTypeText>Бензин</EngineTypeText>\n" +
                "                            <ColorCode>1JF7</ColorCode>\n" +
                "                        </VehicleEngineering>\n" +
                "                    </Vehicle>\n" +
                "                    <PolicyData>\n" +
                "                        <PlateNumber>AA0000AA</PlateNumber>\n" +
                "                        <PolicyNumber>INSURER_Policy_No</PolicyNumber>\n" +
                "                        <PolicyStartDate>2018-08-09</PolicyStartDate>\n" +
                "                        <InsuranceType>FullCoverage</InsuranceType>\n" +
                "                        <PolicyEndDate>2019-08-09</PolicyEndDate>\n" +
                "                        <ProductText>КАСКО Профи 50/50 2018</ProductText>\n" +
                "                        <InsuredAmount>450000</InsuredAmount>\n" +
                "                    </PolicyData>\n" +
                "                    <AccidentData>\n" +
                "                        <AccidentDateTime>2021-10-14T00:00:00.000</AccidentDateTime>\n" +
                "                        <Address>\n" +
                "                            <State>Київська область</State>\n" +
                "                            <City>Київ</City>\n" +
                "                            <Line2>Бальзака 61</Line2>\n" +
                "                        </Address>\n" +
                "                        <AccidentCauseList>\n" +
                "                            <Cause>\n" +
                "                                <Description>Зі слів страхувальника: відбулося зіткнення з тз Hyundai Getz. Поліцію викликали, очікують.</Description>\n" +
                "                            </Cause>\n" +
                "                        </AccidentCauseList>\n" +
                "                    </AccidentData>\n" +
                "                </BasicClaimData>\n" +
                "            </Task>\n" +
                "        </ser:payload>\n" +
                "    </ser:createTaskRequest>\n" +
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
        connection.setRequestProperty("SoapAction", "http://serviceinterface_v1.b2b.audatex.com/TaskServicePort/createTaskRequest");
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
   // System.out.println("Otvet 1 " + line);
        String resultStr = line.substring(line.indexOf("text") + 5, line.indexOf("/text") -1);
        Assert.assertEquals(resultStr, "Operation terminated successfully");
        String resultTask = line.substring(line.indexOf("taskId") + 7, line.indexOf("/taskId") -1);
     //System.out.println("Otvet TaskID " + resultTask);


}
}