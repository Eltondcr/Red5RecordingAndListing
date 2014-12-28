package br.com.dcria.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class RESTApplication extends Application {
 
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    public RESTApplication(){
         singletons.add(new StreamingService());
    }
    @Override
    public Set<Class<?>> getClasses() {
         return empty;
    }
    @Override
    public Set<Object> getSingletons() {
         return singletons;
    }
}