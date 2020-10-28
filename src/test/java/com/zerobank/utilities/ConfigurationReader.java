package com.zerobank.utilities;

import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader
{
    private static Properties properties;

    public static String get(final String keyName) {
        return ConfigurationReader.properties.getProperty(keyName);
    }

    static {
        try {
            final String path = "configuration.properties";
            final FileInputStream input = new FileInputStream(path);
            (ConfigurationReader.properties = new Properties()).load(input);
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}