package smith.tukahirwa.core;

import java.time.LocalDate;
import java.util.List;

public class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private LocalDate borrowed; 
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double price;
    private BookFormat format;
    private BookStatus bookStatus;
    private LocalDate dateOfPurchase;
    private LocalDate publicationDate;
    private Rack placedAt;
    private int checkOutCounter;

    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPages,
                    List<Author> authors, String barcode, boolean isReferenceOnly, LocalDate borrowed,
                    LocalDate returnDate, double price,
                    BookFormat format, BookStatus bookStatus, LocalDate dateOfPurchase, LocalDate publicationDate, int checkOutCounter)
    {
        super(ISBN, title, subject, publisher, language, numberOfPages, authors);
        this.barcode = barcode;
        this.isReferenceOnly = isReferenceOnly;
        this.borrowed = borrowed;
        this.dueDate = borrowed.plusDays(Constants.MAX_LENDING_DAYS);
        this.returnDate = returnDate;
        this.price = price;
        this.format = format;
        this.bookStatus = bookStatus;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
        this.checkOutCounter = checkOutCounter;
        //this.placedAt = placedAt;
    }

    // overload - constructor for ReferenceOnly books

    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPages,
                    List<Author> authors, String barcode, boolean isReferenceOnly,  double price,
                    BookFormat format, LocalDate dateOfPurchase, LocalDate publicationDate)
    {
        super(ISBN, title, subject, publisher, language, numberOfPages, authors);
        this.barcode = barcode;
        this.isReferenceOnly = true;
//        this.borrowed = borrowed; // - for Reference- Only books - no borrowing
        this.dueDate = dueDate;
        this.price = price;
        this.format = format;
        this.bookStatus = BookStatus.AVAILABLE; // always available
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
        //this.placedAt = placedAt;
    }
    public String getBarcode() {
        return barcode;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean getIsReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }

    public LocalDate getBorrowed() {
        return borrowed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus status) {
        this.bookStatus = status;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setBorrowed(LocalDate borrowed) {
        this.borrowed = borrowed;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getCheckOutCounter() {
        return checkOutCounter;
    }

    public void setCheckOutCounter(int checkOutCounter) {
        this.checkOutCounter = checkOutCounter;
    }
// relationship managed by Rack for now -- to update later

    public Rack getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Rack placedAt) {
        this.placedAt = placedAt;
    }



    public boolean checkout(Member member) {
        if(this.getIsReferenceOnly()) {
            showError("Sorry, this book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this, member)){
            return false;
        }
        this.setBookStatus(BookStatus.LOANED);
        return true;
    }

    private void showError(String s) {
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "barcode='" + barcode + '\'' +
                ", isReferenceOnly=" + isReferenceOnly +
                ", borrowed=" + borrowed +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", price=" + price +
                ", format=" + format +
                ", bookStatus=" + bookStatus +
                ", dateOfPurchase=" + dateOfPurchase +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
