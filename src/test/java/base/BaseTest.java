package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    @BeforeClass
    public void setup() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/config.properties"));
            RestAssured.baseURI = props.getProperty("baseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
