/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jpajaxproject.api;

import java.util.Set;

import javax.ws.rs.core.Application;

/**
 *
 * @author Surendra
 */
@javax.ws.rs.ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources=new java.util.HashSet<>();
        addRestResourcesClasses(resources);
        return resources;
        //return new HashSet<Class<?>>(Arrays.asList(SimpleRESTPojo.class, SimpleRESTEJB.class));
        //return super.getClasses(); //To change body of generated methods, choose Tools | Templates.
    }

    private void addRestResourcesClasses(Set<Class<?>> resources) {
        resources.add(com.leapfrog.jpajaxproject.api.DepartmentAPI.class);
    }

   

   
    
    
    
}

