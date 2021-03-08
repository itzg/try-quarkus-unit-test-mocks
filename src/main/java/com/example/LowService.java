package com.example;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class LowService {

    @Inject
    TopService topService;

    @Inject
    MidService midService;

    int startCount;

    public void start(@Observes StartupEvent evt) {
        ++startCount;
    }

    public String doLow() {
        return String.format("real low: started=%d and top reports: %s, and mid reports: %s",
            startCount, topService.doTop(), midService.doMid());
    }
}
