package utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;

    public ConfigLoader(String propertyFilePath){
        properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(propertyFilePath)){
            properties.load(inputStream);
        }catch(IOException e){
            throw new RuntimeException("Properties file was not found at location: " + propertyFilePath);
        }
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
