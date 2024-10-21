package com.example;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }

        // remove non-numeric
        isbn = isbn.replace("-", "");

        // Check for non-numeric characters
        for (char c : isbn.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid character in ISBN: " + c);
            }
        }

        if (isbn.length() == 10) {
            return check10DigitsISBN(isbn);
        } else if (isbn.length() == 13) {
            return check13DigitsISBN(isbn);
        } else {
            throw new IllegalArgumentException("ISBN must be either 10 or 13 digits long.");
        }
    }

    private boolean check10DigitsISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            total += digit * (10 - i);
        }

        return total % 11 == 0;
    }

    public boolean check13DigitsISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            total += (i % 2 == 0) ? digit : digit * 3;
        }
        return total % 10 == 0;
    }
}
