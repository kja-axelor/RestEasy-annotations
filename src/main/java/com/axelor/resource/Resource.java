package com.axelor.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/test")
public class Resource {
	@GET
	@Path("/{name}")
	public Response hello(@PathParam("name") String name)
	{
		return Response.ok("My name is  "+name).build();
	}
}
