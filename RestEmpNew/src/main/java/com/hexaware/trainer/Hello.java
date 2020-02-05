package com.hexaware.trainer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/HelloWorld")
public class Hello {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Welcome to Rest WebServices in FTP115";
    }

    @GET
    @Path("/sum/{i}/{j}")
    @Produces(MediaType.APPLICATION_JSON)
    public String sum(@PathParam("i") int i, @PathParam("j") int j) {
        int c = i+j;
        
        String res = "sum is " +c;
        return res;
    }

    @GET
    @Path("/div/{i}/{j}")
    @Produces(MediaType.APPLICATION_JSON)
    public String div(@PathParam("i") int i, @PathParam("j") int j) {
        int c = i/j;
        String res = "div is " +c;
        return res;
    }
}    