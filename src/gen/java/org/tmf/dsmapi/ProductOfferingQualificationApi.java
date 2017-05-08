package org.tmf.dsmapi;

import org.tmf.dsmapi.service.qualification.model.*;
import org.tmf.dsmapi.ProductOfferingQualificationApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.tmf.dsmapi.service.qualification.model.ProductOfferingQualificationReq;

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
@Path("/productOfferingQualification")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the productOfferingQualification API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:29.034+05:30")
public class ProductOfferingQualificationApi  {

   @EJB
   private ProductOfferingQualificationApiService service;

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "productOfferingQualificationCreate", notes = "", response = ProductOfferingQualificationReq.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "serviceQualification", response = ProductOfferingQualificationReq.class) })
    public Response productOfferingQualificationCreate(@ApiParam(value = "" ,required=true) ProductOfferingQualificationReq productOfferingQualification
,@Context SecurityContext securityContext,@Context UriInfo uriInfo)
    throws NotFoundException {
        return service.productOfferingQualificationCreate(productOfferingQualification,securityContext,uriInfo);
    }
    @GET
    @Path("/{productOfferingQualificationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "productOfferingQualificationGet", notes = "", response = ProductOfferingQualificationReq.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "serviceQualification", response = ProductOfferingQualificationReq.class) })
    public Response productOfferingQualificationGet(@ApiParam(value = "",required=true) @PathParam("productOfferingQualificationId") String productOfferingQualificationId
,@ApiParam(value = "") @QueryParam("fields") String fields
,@Context SecurityContext securityContext,@Context UriInfo uriInfo)
    throws NotFoundException {
        return service.productOfferingQualificationGet(productOfferingQualificationId,fields,securityContext,uriInfo);
    }
}
