package org.acme;

import java.util.List;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Sort;
import io.quarkus.qute.TemplateData;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;

@Entity
@TemplateData
class Person extends PanacheEntity {

    public String name;

    public String surname;

    @WithSession
    public static Uni<List<Person>> listAllSortedByName() {
        return listAll(Sort.ascending("surname", "name"));
    }

}