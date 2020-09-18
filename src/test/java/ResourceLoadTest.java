import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourceLoadTest {
    @Test
    public void testProperties() throws IOException {
        ClassLoader classLoader = ResourceLoadTest.class.getClassLoader();
        URL resource = classLoader.getResource("application.yml");
        InputStream resourceAsStream = classLoader.getResourceAsStream("application.yml");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String port = properties.getProperty("port");
        System.out.println(properties);
    }
}
