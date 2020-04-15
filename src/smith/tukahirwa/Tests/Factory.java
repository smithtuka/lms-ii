package smith.tukahirwa.Tests;

import com.google.gson.Gson;
import smith.tukahirwa.core.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    public static void main(String[] args) throws FileNotFoundException {


        // Librarians


        // Authors


        // List of Members

        // Racks

        // Address


        //BookItems

    }

    // Addresses
    static List<Address> addressList = List.of(
            new Address("100N 4th Street", "Fairfield", "Iowa", "522540", "USA"),
            new Address("100N 5th Street", "Desmoines", "Iowa", "522540", "USA"),
            new Address("100N 6th Street", "Fairfield", "Iowa", "522540", "USA")
    );

    // Persons

    static List<Person> personList = List.of(
            new Person("Smith Tukahirwa", addressList.get(0), "smithtuka@gmail.com", "339-7077670"),
            new Person("Alice Tukahirwa", addressList.get(1), "alicenan@gmail.com", "449-7077678"),
            new Person("Dalson Tukahirwa", addressList.get(2), "dalsonk@gmail.com", "555-34077670"),
            new Person("Smith Tukahirwa", addressList.get(0), "smithtuka@gmail.com", "339-7077670")
    );

    // Librarian
    List<Librarian> librarianList = List.of(
            new Librarian("L2003", AccountStatus.ACTIVE, personList.get(3)),
            new Librarian("L3004", AccountStatus.ACTIVE, personList.get(2)),
            new Librarian("L2005", AccountStatus.ACTIVE, personList.get(1))

    );


    // Authors - cd use persons here as well
    static List<Author> authorList;

    static {
        authorList = new ArrayList<>();
        authorList.add(new Author("Chinua Achebe", null, "achebe@msn.net", "785-646230"));
        authorList.add(new Author("Timothy Wangusa", null, "achebe@msn.net", "785-646230"));
        authorList.add(new Author("Polpot King", null, "achebe@msn.net", "785-646230"));
        authorList.add(new Author("Shergold Achebe", null, "achebe@msn.net", "785-646230"));
    }

    public static List<Author> testAuthors = new ArrayList<>(); static {
        testAuthors.add(authorList.get(0));
        testAuthors.add(authorList.get(1));
    }


    // List of BookItems
    public static List<BookItem> bookItemList = List.of(
      new BookItem("B-0098-SN-98","The Lion & the Jew", "Literature", "MK Publishers Ltd",
              "ENGLISH", 500, authorList.subList(1, 2), "LT-002-001BC",false,
              LocalDate.of(2020,03,01), LocalDate.of(2020,03,21),
              230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
              LocalDate.of(2019,12,01),
              LocalDate.of(2019,05,01), 5 ),

            new BookItem("B-0098-SN-99","Gutten Bend- Auf", "Biology", "Pearson Publishers",
                    "GERMAN", 300, authorList.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            //reserveOnly
            new BookItem("GNB-0098-SN-99","The Good News", "Christianity", "Smartson Publishers",
                    "ARABIC", 8000, authorList.subList(2, 3), "CR-002-01BC",true,
                    230, BookFormat.HARDCOVER,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01) )
    );

    // Members

    public static List<Member> memberList = List.of(

            // some with no books, others late returns, others, cancelled status, others, in same address, some new members,
            new Member("M-001", AccountStatus.ACTIVE, personList.get(0), LocalDate.of(2020,04,10),  new ArrayList<BookItem>()),
            new Member("M-002", AccountStatus.ACTIVE, personList.get(1), LocalDate.of(2020,04,11), bookItemList.subList(0,0)),
            new Member("M-003", AccountStatus.CANCELED, personList.get(2), LocalDate.of(2020,03,12), bookItemList.subList(0,1))

    );

    // Racks
   //static List <List<Rack>> RackList; - - might need it as List of Arrays/lists
    static List<Rack> RackList;

    static {
        RackList = new ArrayList<>();
        RackList.add(new Rack(100, "L-01-01", bookItemList.subList(0, 0)));
        RackList.add(new Rack(200, "G-01-01", bookItemList.subList(1, 1)));
    }





}
