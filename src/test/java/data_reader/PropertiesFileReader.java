package data_reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public  class PropertiesFileReader {
    public Properties FileUpload() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = null;
        String filename="src/test/java/config/Android_config.properties";
        try {
            fis=new FileInputStream(filename);
            prop.load(fis);
        }  catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
