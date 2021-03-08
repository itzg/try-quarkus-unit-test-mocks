package com.example;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class LowServiceTest {

    @Inject
    LowService lowService;

    @InjectMock
    TopService topService;

    @InjectMock
    MidService midService;

    @Test
    void serviceWorks() {
        Mockito.when(topService.doTop()).thenReturn("mock top from low");
        Mockito.when(midService.doMid()).thenReturn("mock mid from low");

        assertEquals("real low: started=1 and top reports: mock top from low, and mid reports: mock mid from low",
            lowService.doLow());
    }
}