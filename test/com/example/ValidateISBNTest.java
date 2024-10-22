package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {


    // checkAValid10DigitISBN
    @Test
    public void checkAValidI10DigitISBN() {
        // Arrange
        ValidateISBN validateISBN = new ValidateISBN();

        // Act
        boolean result1 = validateISBN.checkISBN("0735211299");
        boolean result2 = validateISBN.checkISBN("0857197681");

        // Assert
        assertTrue(result1, "first valid 10 digits ISBN");
        assertTrue(result2, "second valid 10 digits ISBN");

    }


    // checkA10DigitInValidISBN
    @Test
    public void checkAnIvalidISBN() {
        //Arrange
        ValidateISBN validateISBN = new ValidateISBN();

        // Act
        boolean result = validateISBN.checkISBN("1234567890");

        // Assert
        assertFalse(result, "invalid 10 digits ISBN");
    }


    /*
    Write a test to:
    (1) Check that "helloworld" gives a number format exception.
    (2) Check a valid and invalid 13 digit ISBN number.
     */

    // checkAValid13DigitISBN
    // 13-Digits Valid example: 978-0735211292
    @Test
    public void checkAValid13DigitISBN() {
        //Arrange
        ValidateISBN validateISBN = new ValidateISBN();

        //Act
        boolean result1 = validateISBN.checkISBN("9781853267338");
        boolean result2 = validateISBN.checkISBN("978-0735211292");

        // Asset
        assertTrue(result1, "first valid 13 digits ISBN");
        assertTrue(result2, "second valid 13 digits ISBN");

    }


    // checkA13DigitInvalidISBN
    @Test
    public void checkA13DigitInValidISBN() {
        //Arrange
        ValidateISBN validateISBN = new ValidateISBN();

        //Act
        boolean result = validateISBN.checkISBN("9781853267336");

        // Asset
        assertFalse(result, "invalid 13 digits ISBN");
    }


    // non-NumericISBNIsNotAllowed:  "helloworld"
    @Test
    public void nonNumericISBNIsNotAllowed() {
        // Arrange
        ValidateISBN validateISBN = new ValidateISBN();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateISBN.checkISBN("helloworld");
        });

        // Verify that the exception message is as expected
        assertEquals("Invalid character in ISBN: h", exception.getMessage());
    }

}
