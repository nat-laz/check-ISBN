package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StockManagementTests {

    @Test
    public void testCanGetACorrectLocatorCode() {

        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book("0582827647", "Of Mice and Men", "John Steinbeck");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(testService);
        String isbn = "0582827647";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7647J4", locatorCode);
    }
}
