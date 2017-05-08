package org.tmf.dsmapi;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.tmf.dsmapi.commons.jaxrs.JacksonFeature;
import org.tmf.dsmapi.hub.HubResource;
import org.tmf.dsmapi.product.qualification.ProductOfferingQualificationAdminResource;
import org.tmf.dsmapi.service.qualification.ServiceQualificationAdminResource;

@javax.ws.rs.ApplicationPath("api/v1")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        ResourceConfig packages = packages("com.fasterxml.jackson.jaxrs.json");
        register(JacksonFeature.class);
        register(org.tmf.dsmapi.commons.jaxrs.BadUsageExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.JacksonConfigurator.class);
        register(org.tmf.dsmapi.commons.jaxrs.JsonMappingExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(ServiceQualificationAdminResource.class);
        register(ServiceQualificationApi.class);
        register(ProductOfferingQualificationAdminResource.class);
        register(ProductOfferingQualificationApi.class);
        register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        register(HubResource.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8383");
        beanConfig.setBasePath("/DSServiceQualificationManagement/api/v1");
        //beanConfig.setFilterClass("io.swagger.sample.util.ApiAuthorizationFilterImpl");
        beanConfig.setResourcePackage("org.tmf.dsmapi");
        beanConfig.setScan(true);
    }

}
