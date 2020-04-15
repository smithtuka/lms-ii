package smith.tukahirwa.core;

import java.util.Date;

public class BookLending {
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private BookItem bookItem;
    private Member member;

    public BookLending(Date creationDate, Date dueDate, Date returnDate, BookItem bookItem, Member member) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.bookItem = bookItem;
        this.member = member;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookIteme) {
        this.bookItem= bookItem;
    }

    public Member getMemberId() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public static boolean lendBook(BookItem bookItem, Member member){ // void
        // implement

        return false;
    }
    public static BookLending fetchLendingDetails(BookItem bookItem){
        // implement
        return null;
    }
}