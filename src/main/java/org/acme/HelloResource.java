package org.acme;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    @CheckedTemplate
    class Templates {
         static native TemplateInstance hello(String name);
    }

    @GET
    @Path("/{name}")
    public TemplateInstance hello(String name) {
        return Templates.hello(name);
    }

}