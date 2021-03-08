package com.example;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class TopService {

    int startCount;

    public void start(@Observes StartupEvent evt) {
        ++startCount;
    }

    public String doTop() {
        return String.format("real top: started=%d", startCount);
    }
}
