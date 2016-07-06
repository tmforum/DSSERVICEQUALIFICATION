package org.tmf.dsmapi;

import org.glassfish.jersey.server.ResourceConfig;
import org.tmf.dsmapi.commons.jaxrs.JacksonFeature;
import org.tmf.dsmapi.hub.HubResource;
import org.tmf.dsmapi.product.qualification.ProductOfferingQualificationAdminResource;
import org.tmf.dsmapi.product.qualification.ProductOfferingQualificationResource;
import org.tmf.dsmapi.service.qualification.ServiceQualificationAdminResource;
import org.tmf.dsmapi.service.qualification.ServiceQualificationResource;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        ResourceConfig packages = packages ("com.fasterxml.jackson.jaxrs.json");
        register(JacksonFeature.class);
        register(org.tmf.dsmapi.commons.jaxrs.BadUsageExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.JacksonConfigurator.class);
        register(org.tmf.dsmapi.commons.jaxrs.JsonMappingExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(ServiceQualificationAdminResource.class);
        register(ServiceQualificationResource.class);
        register(ProductOfferingQualificationAdminResource.class);
        register(ProductOfferingQualificationResource.class);
        register(HubResource.class);
    }

}
