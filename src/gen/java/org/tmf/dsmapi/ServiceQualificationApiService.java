package org.tmf.dsmapi;

import org.tmf.dsmapi.*;
import org.tmf.dsmapi.service.qualification.model.*;


import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;

import java.util.List;
import org.tmf.dsmapi.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:45.112+05:30")
public interface ServiceQualificationApiService {
    
    public Response serviceQualificationFind(String fields,SecurityContext securityContext,UriInfo uriInfo) throws NotFoundException;
    
    public Response serviceQualificationCreate(ServiceQualificationReq serviceQualification,SecurityContext securityContext,UriInfo uriInfo) throws NotFoundException;
    
    public Response serviceQualificationGet(String serviceQualificationId,String fields,SecurityContext securityContext,UriInfo uriInfo) throws NotFoundException;
    
}
