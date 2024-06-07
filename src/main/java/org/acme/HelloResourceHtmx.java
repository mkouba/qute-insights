package org.acme;

import java.time.LocalDateTime;

import org.jboss.resteasy.reactive.RestQuery;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello-htmx")
public class HelloResourceHtmx {

    @CheckedTemplate
    class Templates {
        static native TemplateInstance hello(String name, LocalDateTime generatedAt);

        static native TemplateInstance hello$appInfo();

    }

    @GET
    public TemplateInstance hello(@RestQuery String name) {
        return Templates.hello(name, LocalDateTime.now());
    }

    @GET
    @Path("/app-info")
    public TemplateInstance appInfo() {
        return Templates.hello$appInfo();
    }

}