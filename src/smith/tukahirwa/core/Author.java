package smith.tukahirwa.core;

import java.util.List;

public class Author extends Person{
    List<Book> books;
    public Author(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    // relationship owner is BookItem for now
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // implement further


    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        return books != null ? books.equals(author.books) : author.books == null;
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }
}
