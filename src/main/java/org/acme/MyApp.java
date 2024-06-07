package org.acme;

import java.time.Duration;
import java.time.Instant;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.Startup;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Startup
@Named("app")
@Singleton
public class MyApp {

    @Inject
    LaunchMode mode;

    final Instant startedAt = Instant.now();

    public LaunchMode mode() {
        return mode;
    }

    public Duration uptime() {
        return Duration.between(startedAt, Instant.now());
    }
}
