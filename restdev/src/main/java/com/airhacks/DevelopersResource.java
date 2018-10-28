/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author cristiandrincu
 */
@Path("developers")
public class DevelopersResource {
   
    @GET
    @Path("developer")
    public JsonArray developers(@Context HttpHeaders http) {
        JsonObject object =  Json.createObjectBuilder().add("firstname", "duchess").build();
        return Json.createArrayBuilder().add(object).build();
//        throw new RuntimeException("no developers found");
    }
    
    @GET
    @Path("{first}-{last}")
    public JsonObject developer(@PathParam("first") String first, @PathParam("last") String last) {
        Developer dev = new Developer(first, last);
        return Json.createObjectBuilder().add("firstname", dev.getName()).add("lastname", dev.getLast()).build();
    }
}
