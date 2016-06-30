/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Lin
 */
public class PropertiesLoader {
    
    private final Map<String, Properties> propertiesCache = new HashMap<>();
    
    /**
     * 
     * @param fileName
     * @return
     * @throws IOException 
     */
    public Properties loadProperties(String fileName) throws IOException {
        Properties props = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        props.load(inputStream);
        //props.load(PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName));
        
        propertiesCache.put(fileName, props);
        
        return props;
    }
    
    /**
     * 
     * @param fileName
     * @return
     * @throws IOException 
     */
    public boolean closeProperties(String fileName) throws IOException {
        Properties props = propertiesCache.get(fileName);
        if(props != null) {
            props.clone();
            propertiesCache.remove(fileName);
            return true;
        }
        return false;
    }
    
}
