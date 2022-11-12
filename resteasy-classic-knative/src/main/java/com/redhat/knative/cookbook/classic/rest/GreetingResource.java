package com.redhat.knative.cookbook.classic.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/serving")
public class GreetingResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/{bucket-name}/{bucket-key}")
  public String hello(@PathParam("bucket-name") String bucketName, @PathParam("bucket-key") String bucketKey) {
    return String.format("Hello from Knative Serving %s-%s", bucketName, bucketKey);
  }
}