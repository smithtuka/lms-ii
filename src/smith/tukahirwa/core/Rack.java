package smith.tukahirwa.core;

import java.util.List;

public class Rack {
        private int number;
        private String locationIdentifier; // Subject + RowNum + slotNum e.g (L-01-01)
        List<BookItem> books;

    public Rack(int number, String locationIdentifier, List<BookItem> books) {
        this.number = number;
        this.locationIdentifier = locationIdentifier;
        this.books = books;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    public void setLocationIdentifier(String locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
    }

    public List<BookItem> getBooks() {
        return books;
    }

    public void setBooks(List<BookItem> books) {
        this.books = books;
    }
    // implement further
    }


