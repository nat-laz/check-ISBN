package com.example;

public class StockManager {

    private ExternalISBNDataService service; // this.service

    public void setService(ExternalISBNDataService service) {
        this.service = service;
    }

    public String getLocatorCode(String isbn) {
        Book book = service.lookup(isbn);

        StringBuilder locator = new StringBuilder();

        // last 4 digits of ISBN + initial letter of author + number of words in title

        // last 4 digits of ISBN
        locator.append(isbn.substring(isbn.length() - 4));
        // 0582827647 <-- isbn
        // 0123456789 <-- index
        // 10-4 = 6

        // initial letter of author
        locator.append(book.getAuthor().substring(0, 1));  // locator.append(book.getAuthor().charAt(0));

        // number of words in title
        locator.append(book.getTitle().split(" ").length);

        return locator.toString();
    }
}
