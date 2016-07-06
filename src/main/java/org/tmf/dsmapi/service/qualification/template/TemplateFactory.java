/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template;

import java.util.Properties;
import org.tmf.dsmapi.commons.utils.PropertiesLoader;

/**
 *
 * @author Lin
 */
public class TemplateFactory {
    
    private final static TemplateFactory factory = new TemplateFactory();
    
    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    
    public static TemplateFactory getInstance() {
        return factory;
    }
    
    /**
     * 
     * @param templateKey
     * @return
     * @throws Exception 
     */
    public String getTemplateName(String templateKey) throws Exception {
        Properties props = propertiesLoader.loadProperties("serviceBinding.properties");
        if(props != null) {
            String templateName = props.getProperty(templateKey);
            return templateName;
        }
        return null;
    }
    
    
}
