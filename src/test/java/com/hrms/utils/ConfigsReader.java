package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    //**+enter

    static Properties prop;
    /**
     * This method reads any given property file
     * @param filePath
     * @return Properties
     */
    public static Properties readProperties(String filePath) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop=new Properties();
            prop.load(fis);
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return prop;
    }


    /**
     * Thos method retrieves single value based on the specified key
     * @param key
     * @return
     */

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }



}
