package org.tmf.dsmapi;

import org.tmf.dsmapi.*;
import org.tmf.dsmapi.service.qualification.model.*;


import org.tmf.dsmapi.service.qualification.model.ProductOfferingQualificationReq;

import java.util.List;
import org.tmf.dsmapi.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:29.034+05:30")
public interface ProductOfferingQualificationApiService {
    
    public Response productOfferingQualificationCreate(ProductOfferingQualificationReq productOfferingQualification,SecurityContext securityContext,UriInfo uriInfo) throws NotFoundException;
    
    public Response productOfferingQualificationGet(String productOfferingQualificationId,String fields,SecurityContext securityContext,UriInfo uriInfo) throws NotFoundException;
    
}
