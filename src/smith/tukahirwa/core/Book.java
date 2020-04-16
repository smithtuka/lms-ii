package smith.tukahirwa.core;

import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    // implement further


    public Book(String ISBN, String title, String subject, String publisher, String language, int numberOfPages, List<Author> authors) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return this.getTitle().equals(book.getTitle());
    }

}
