package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.service.EuclideanService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {
    
    //@Autowired
    private static EuclideanService euclideanService;

    @Autowired
    public ApplicationTest(EuclideanService euclideanService) {
        this.euclideanService = euclideanService;
    }
    
    @Test
    public void checkSimple() {
        String expected = "6";
        String actual = euclideanService.calculateGCD("18", "30");
        Assertions.assertEquals(expected, actual, "check GCD(18,30)");
    }

    @Test
    public void checkOne() {
        String expected = "1";
        String actual = euclideanService.calculateGCD("1", "5");
        Assertions.assertEquals(expected, actual, "check GCD(1,5)");
    }

    @Test
    public void checkEquals() {
        String expected = "2";
        String actual = euclideanService.calculateGCD("2", "2");
        Assertions.assertEquals(expected, actual, "check GCD(2,2)");
    }

    @Test
    public void checkZero() {
        String expected = "2";
        String actual = euclideanService.calculateGCD("0", "2");
        Assertions.assertEquals(expected, actual, "check GCD(0,2)");
    }

    @Test
    public void checkNegative() {
        String expected = "4";
        String actual = euclideanService.calculateGCD("-8", "20");
        Assertions.assertEquals(expected, actual, "check GCD(-8,20)");
    }

    @Test
    public void checkInvalidData() {
        String expected = "4";
        String actual = euclideanService.calculateGCD("-8a", "20b");
        Assertions.assertEquals(expected, actual, "check GCD(8a,20b)");
    }

}
