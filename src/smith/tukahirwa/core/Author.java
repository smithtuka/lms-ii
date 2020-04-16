package smith.tukahirwa.core;

import java.util.List;

public class Author extends Person{

    public Author(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    // relationship owner is BookItem for now

    // implement further


    @Override
    public boolean equals(Object obj) {
        Author author = (Author) obj;
        return this.getEmail().equals(((Author) obj).getEmail());
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" +
                '}';
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Author)) return false;
//
//        Author author = (Author) o;
//
//        return books != null ? books.equals(author.books) : author.books == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return books != null ? books.hashCode() : 0;
//    }
}
