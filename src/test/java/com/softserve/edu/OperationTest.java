package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.softserve.edu.service.OperationService;
import com.softserve.edu.service.impl.AddOperationService;

public class OperationTest {

    @Test
    public void testAddOperationService() {
        OperationService operationService = new AddOperationService();
        String expected = "10";
        String actual = operationService.operation("6", "4");
        Assertions.assertEquals(expected, actual);
    }
}
