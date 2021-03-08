package com.example;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class MidService {

    @Inject
    TopService topService;

    int startCount;

    public void start(@Observes StartupEvent evt) {
        ++startCount;
    }

    public String doMid() {
        return String.format("real mid: started=%d and top reports: %s",
            startCount, topService.doTop());
    }
}
