package com.xvictum.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.xvictum.rest.util.CORSResponseFilter;

@ApplicationPath("/rest")

public class RestApplication extends Application {

	/*@Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(CORSResponseFilter.class);

        return resources;
    }*/
}