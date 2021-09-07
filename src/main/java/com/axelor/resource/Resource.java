package com.axelor.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.axelor.students.Student;

@Path("/test")
public class Resource {
	
//	PATH PARAM
	
	@GET
	@Path("/person/{krjani}")
	public Response hello(@PathParam("krjani") String name)
	{
		return Response.ok("My name is  "+name).build();
	}
	
//	POJO-IMPLEMENTATION
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student hello()
	{
		Student s = new Student(1,"krjani");
		System.out.println(s.toString());
		return s;
	}
	
	//MatrixParam
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	public String getResource(
			@MatrixParam("std1") String roll1,
			@MatrixParam("std2") String roll2 ){
		return "you sent me 2 documents  "+roll1 + " and " +roll2 ;
	}
	
	//@QueryParam
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	public String getResource(
			@QueryParam("std1") String roll1, 
	         // Here std1 will be mapped with roll1
			@QueryParam("std2") String roll2 ){
		return "you sent me 2 documents  "+roll1 + " and " +roll2 ;
	}
	
	
	@POST
	@Path("/add")
	public String addStudentInfo(
			@FormParam("sname") String name,
			@FormParam("sage") int age) {
		return "Web service has added the student information with name : "+ name + ", and age : "+ age;
	}
	
	
	//uriInfo --> UrlInformations
	//HttpHeaders --> give information regarding headers
	
	@GET
	@Path("context")
	public String getParamasUsingContext(@Context UriInfo uri, @Context HttpHeaders hdr) {
		String name = uri.getAbsolutePath().toString();
		String ck = hdr.getCookies().toString();
		return "path is " + name + "<br>" + "Cookie is " + ck;
	}
	
	
	
}