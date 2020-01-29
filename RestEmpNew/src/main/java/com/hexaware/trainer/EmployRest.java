package com.hexaware.trainer;
import com.hexaware.factory.EmployFactory;
import com.hexaware.model.Employ;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
 @Path("/Emp")
 public class EmployRest {
	 @POST
  @Path("/employInsert/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String insertEmploy(final Employ e) {
    String s =EmployFactory.addEmploy(e);
    System.out.println(s);
    return s;
  }
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employ employeeListById(@PathParam("id") int id) {
	  Employ empl = EmployFactory.showEmploy(id);
	  if (empl == null) {
		throw new NotFoundException("No such Employee ID: " + id);
	  }
	  return empl;
	}
     @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Employ[] employeesList() {
	    Employ[] employees = EmployFactory.showEmploy();
	    return employees;
	  }
 }