package org.acme;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateExtension;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello-ext-method")
public class HelloResourceExtMethod {

    @CheckedTemplate
    class Templates {
        static native TemplateInstance hello(String name);
    }

    @GET
    @Path("/{name}")
    public TemplateInstance hello(String name) {
        return Templates.hello(name);
    }

    @TemplateExtension
    static String reversed(String value) {
        return new StringBuilder(value).reverse().toString();
    }

}