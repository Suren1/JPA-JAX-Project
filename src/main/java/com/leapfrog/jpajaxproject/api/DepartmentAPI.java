package com.leapfrog.jpajaxproject.api;

import com.leapfrog.jpajaxproject.dao.DepartmentDAO;
import com.leapfrog.jpajaxproject.dao.impl.DepartmentDAOImpl;
import com.leapfrog.jpajaxproject.entity.Department;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/departmentapi")

public class DepartmentAPI {

    private DepartmentDAO dptDAO= new DepartmentDAOImpl();
    
    @Produces (value = MediaType.APPLICATION_JSON)
    @GET
    public List<Department> index(){
        //dptDAO.insert(new Department(1, "IELTS", true));
        return dptDAO.getAll();
    }   
    
    @Path("/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Department get(@PathParam("id")int id){
        return dptDAO.getById(id);
    }
    
    @Path("/save")
    @POST
    public String  save(@FormParam ("name") String name,@FormParam ("status")boolean status){
        Department d= new Department(0,name,status);
        dptDAO.insert(d);
            
        
        return "done";
    }
    
}