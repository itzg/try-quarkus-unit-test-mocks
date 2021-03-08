package com.example;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class MidServiceTest {

    @Inject
    MidService midService;

    @InjectMock
    TopService topService;

    @Test
    void serviceWorks() {
        Mockito.when(topService.doTop()).thenReturn("mock top from mid");
        assertEquals("real mid: started=1 and top reports: mock top from mid",
            midService.doMid());
    }
}