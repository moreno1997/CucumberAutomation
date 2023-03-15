package utilities; //utility, always static

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {


    private static Properties properties; // when we need to login, get url, don't need to hardcode, can control from one place

    static {
        try {
            properties = new Properties();

            FileInputStream file = new FileInputStream("configurations.properties");
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("Configuration file not found");
        }
    }
    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
