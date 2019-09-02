package com.johnny.sars.lang.config;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * Created By: yangtao3
 */
@Slf4j
public class AppConfig {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            Reader reader = new InputStreamReader(in, "UTF-8");
            properties.load(reader);
            reader.close();
        } catch (Exception e) {
            log.error("failed to load config.properties ... ", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
