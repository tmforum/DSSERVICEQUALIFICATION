package org.tmf.dsmapi;

import org.tmf.dsmapi.service.qualification.model.*;
import org.tmf.dsmapi.ServiceQualificationApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;

import java.util.List;
import org.tmf.dsmapi.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ejb.Stateless;
import javax.ejb.EJB;

@Stateless
@Path("/serviceQualification")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the serviceQualification API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:45.112+05:30")
public class ServiceQualificationApi  {

   @EJB
   private ServiceQualificationApiService service;

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "serviceQualificationFind", notes = "", response = ServiceQualificationRsp.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "List of ServiceQualification", response = ServiceQualificationRsp.class, responseContainer = "List") })
    public Response serviceQualificationFind(@ApiParam(value = "") @QueryParam("fields") String fields
,@Context SecurityContext securityContext,@Context UriInfo uriInfo)
    throws NotFoundException {
        return service.serviceQualificationFind(fields,securityContext,uriInfo);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "serviceQualificationCreate", notes = "", response = ServiceQualificationRsp.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "serviceQualification", response = ServiceQualificationRsp.class) })
    public Response serviceQualificationCreate(@ApiParam(value = "" ,required=true) ServiceQualificationReq serviceQualification
,@Context SecurityContext securityContext,@Context UriInfo uriInfo)
    throws NotFoundException {
        return service.serviceQualificationCreate(serviceQualification,securityContext,uriInfo);
    }
    @GET
    @Path("/{serviceQualificationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "serviceQualificationGet", notes = "", response = ServiceQualificationRsp.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "serviceQualification", response = ServiceQualificationRsp.class) })
    public Response serviceQualificationGet(@ApiParam(value = "",required=true) @PathParam("serviceQualificationId") String serviceQualificationId
,@ApiParam(value = "") @QueryParam("fields") String fields
,@Context SecurityContext securityContext,@Context UriInfo uriInfo)
    throws NotFoundException {
        return service.serviceQualificationGet(serviceQualificationId,fields,securityContext,uriInfo);
    }
}
