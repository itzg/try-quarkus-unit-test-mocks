package com.example;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
class TopServiceTest {

    @Inject
    TopService topService;

    @Test
    void serviceWorks() {
        assertEquals("real top: started=1", topService.doTop());
    }
}