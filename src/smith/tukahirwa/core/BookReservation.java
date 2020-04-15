package smith.tukahirwa.core;

import java.util.Date;

// functions

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public BookReservation(Date creationDate, ReservationStatus status, String bookItemBarcode, String memberId) {
        this.creationDate = creationDate;
        this.status = status;
        this.bookItemBarcode = bookItemBarcode;
        this.memberId = memberId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void updateStatus(ReservationStatus status) {
        //implement
        this.status = status;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public static BookReservation fetchReservationDetails(String barcode){
        // implement
        return null;
    }
}