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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rack)) return false;

        Rack rack = (Rack) o;

        if (number != rack.number) return false;
        if (locationIdentifier != null ? !locationIdentifier.equals(rack.locationIdentifier) : rack.locationIdentifier != null)
            return false;
        return books != null ? books.equals(rack.books) : rack.books == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (locationIdentifier != null ? locationIdentifier.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}


