package smith.tukahirwa.core;

import java.util.Date;

// Implement with Streams

public class Fine {
    private Date creationDate;
    private double bookItemBarcode;
    private String memberId;

    public Fine(Date creationDate, double bookItemBarcode, String memberId) {
        this.creationDate = creationDate;
        this.bookItemBarcode = bookItemBarcode;
        this.memberId = memberId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(double bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public static void collectFine(String memberId, long days) {}
}