package smith.tukahirwa.Tests;

import smith.tukahirwa.core.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    public static void main(String[] args) throws FileNotFoundException {


    }

    // Addresses
    static List<Address> addressList = List.of(
            new Address("100N 4th Street", "Fairfield", "Iowa", "522540", "USA"),
            new Address("100N 5th Street", "Desmoines", "Iowa", "522540", "USA"),
            new Address("100N 6th Street", "Fairfield", "Iowa", "522540", "USA")
    );

    static List<Address> addressList2 = List.of(
            new Address("100N 4th Street", "Fairfield", "Iowa", "522540", "USA"),
            new Address("100N 5th Street", "Desmoines", "Iowa", "522540", "USA"),
            new Address("123N 6th Street", "Fairfield", "Iowa", "522540", "USA"),
            new Address("321N 7th Street", "Desmoines", "Iowa", "522512", "USA"),
            new Address("123N 8th Street", "Fairfield", "Iowa", "522513", "USA"),
            new Address("123N 9th Street", "Desmoines", "Iowa", "522514", "USA"),
            new Address("1345N 10th Street", "Fairfield", "Iowa", "522515", "USA"),
            new Address("5345K 11th Street", "Desmoines", "Iowa", "522516", "USA"),
            new Address("980J 12th Street", "Fairfield", "Iowa", "522517", "USA"),
            new Address("980J 12th Street", "Desmoines", "Iowa", "522518", "USA")
    );

    // Persons

    static List<Person> personList = List.of(
            new Person("Smith Tukahirwa", addressList.get(0), "smithtuka@gmail.com", "339-7077670"),
            new Person("Alice Tukahirwa", addressList.get(1), "alicenan@gmail.com", "449-7077678"),
            new Person("Dalson Tukahirwa", addressList.get(2), "dalsonk@gmail.com", "555-34077670"),
            new Person("Smith Tukahirwa", addressList.get(0), "smithtuka@gmail.com", "339-7077670")
    );

    static List<Person> personList2 = List.of(
            new Person("John Tukahirwa", addressList2.get(0), "smithtuka@gmail.com", "339-7077670"),
            new Person("Alice Tukahirwa", addressList2.get(1), "alicenan@gmail.com", "449-12314151"),
            new Person("Alison Tukahirwa", addressList2.get(2), "alison@gmail.com", "555-123415167"),
            new Person("Daisy Tukahirwa", addressList2.get(3), "daisy@gmail.com", "414-12316452"),
            new Person("Kenneth Tukahirwa", addressList2.get(4), "kenneth@gmail.com", "441-41516765"),
            new Person("Brock Tukahirwa", addressList2.get(5), "brock@gmail.com", "334-2345643"),
            new Person("Rob Tukahirwa", addressList2.get(6), "rob@gmail.com", "421-2345626"),
            new Person("Katie Tukahirwa", addressList2.get(7), "katie@gmail.com", "554-6776524"),
            new Person("James Tukahirwa", addressList2.get(8), "james@gmail.com", "324-2345667"),
            new Person("Dan Tukahirwa", addressList2.get(9), "dan@gmail.com", "339-2344334")
    );

    // Librarian
    List<Librarian> librarianList = List.of(
            new Librarian("L2003", AccountStatus.ACTIVE, personList.get(3)),
            new Librarian("L3004", AccountStatus.ACTIVE, personList.get(2)),
            new Librarian("L2005", AccountStatus.ACTIVE, personList.get(1))

    );

    List<Librarian> librarianList2 = List.of(
            new Librarian("L2003", AccountStatus.ACTIVE, personList2.get(1)),
            new Librarian("L3004", AccountStatus.ACTIVE, personList2.get(2)),
            new Librarian("L3005", AccountStatus.ACTIVE, personList2.get(3)),
            new Librarian("L3006", AccountStatus.ACTIVE, personList2.get(4)),
            new Librarian("L3007", AccountStatus.ACTIVE, personList2.get(5)),
            new Librarian("L3008", AccountStatus.ACTIVE, personList2.get(6)),
            new Librarian("L3009", AccountStatus.ACTIVE, personList2.get(6)),
            new Librarian("L3010", AccountStatus.ACTIVE, personList2.get(2)),
            new Librarian("L3011", AccountStatus.ACTIVE, personList2.get(3)),
            new Librarian("L2012", AccountStatus.ACTIVE, personList2.get(4))

    );


    // Authors - cd use persons here as well
    static List<Author> authorList;

    static {
        authorList = new ArrayList<>();
        authorList.add(new Author("Chinua Achebe", null, "achebe@msn.net", "785-646230"));
        authorList.add(new Author("Timothy Wangusa", null, "timothy@msn.net", "785-123412"));
        authorList.add(new Author("Polpot King", null, "polpot@msn.net", "785-312341"));
    }

    static List<Author> authorList2;

    static {
        authorList2 = new ArrayList<>();
        authorList2.add(new Author("Chinua Achebe", null, "achebe@msn.net", "785-646230"));
        authorList2.add(new Author("Timothy Wangusa", null, "timothy@msn.net", "785-123412"));
        authorList2.add(new Author("Polpot King", null, "polpot@msn.net", "785-312341"));
        authorList2.add(new Author("Sherry Berry", null, "sherry@msn.net", "785-141516"));
        authorList2.add(new Author("Apple Smith", null, "apple@msn.net", "785-123511"));
        authorList2.add(new Author("Andy Achebe", null, "andy@msn.net", "785-123412"));
        authorList2.add(new Author("Russell Achebe", null, "russell@msn.net", "785-565443"));
        authorList2.add(new Author("Anthony Sky", null, "anthony@msn.net", "785-654234"));
        authorList2.add(new Author("Randle James", null, "randle@msn.net", "785-467654"));
        authorList2.add(new Author("Kate Achebe", null, "kate@msn.net", "785-555960"));
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

    public static List<BookItem> bookItemList2 = List.of(
      new BookItem("B-0098-SN-98","The Lion & the Jew", "Literature", "MK Publishers Ltd",
              "ENGLISH", 500, authorList.subList(0, 1), "LT-002-001BC",false,
              LocalDate.of(2020,03,01), LocalDate.of(2020,03,21),
              230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
              LocalDate.of(2019,12,01),
              LocalDate.of(2019,05,01), 5 ),

            new BookItem("B-0098-SN-99","Gutten Bend- Auf", "Biology", "Pearson Publishers",
                    "GERMAN", 300, authorList2.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            new BookItem("B-0098-SN-97","Gutten Bend- Auf", "History", "Pearson Publishers",
                    "GERMAN", 300, authorList2.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            new BookItem("B-0098-SN-96","Gutten Bend- Auf", "Algebra", "Pearson Publishers",
                    "GERMAN", 300, authorList2.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            new BookItem("B-0098-SN-95","Gutten Bend- Auf", "Chemistry", "Pearson Publishers",
                    "GERMAN", 300, authorList2.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            new BookItem("B-0098-SN-94","Gutten Bend- Auf", "Science", "Pearson Publishers",
                    "GERMAN", 300, authorList2.subList(1, 2), "LT-002-001BC",false,
                    LocalDate.of(2020,02,9), LocalDate.of(2020,02,19),
                    230, BookFormat.HARDCOVER, BookStatus.AVAILABLE,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01), 45 ),

            //reserveOnly
            new BookItem("GNB-0098-SN-99","The Good News", "Christianity", "Smartson Publishers",
                    "ARABIC", 8000, authorList2.subList(2, 3), "CR-002-01BC",true,
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

    public static List<Member> memberList2 = List.of(

            // some with no books, others late returns, others, cancelled status, others, in same address, some new members,
            new Member("M-001", AccountStatus.ACTIVE, personList2.get(0), LocalDate.of(2020,04,10),  new ArrayList<BookItem>()),
            new Member("M-002", AccountStatus.ACTIVE, personList2.get(1), LocalDate.of(2020,04,11), bookItemList2.subList(0,0)),
            new Member("M-003", AccountStatus.CANCELED, personList2.get(2), LocalDate.of(2020,03,12), bookItemList2.subList(0,1)),
            new Member("M-004", AccountStatus.CANCELED, personList2.get(3), LocalDate.of(2020,03,20), bookItemList2.subList(0,2)),
            new Member("M-005", AccountStatus.ACTIVE, personList2.get(4), LocalDate.of(2020,01,13), bookItemList2.subList(0,3)),
            new Member("M-006", AccountStatus.ACTIVE, personList2.get(5), LocalDate.of(2020,01,11), bookItemList2.subList(0,4)),
            new Member("M-007", AccountStatus.ACTIVE, personList2.get(6), LocalDate.of(2020,02,26), bookItemList2.subList(0,5)),
            new Member("M-008", AccountStatus.ACTIVE, personList2.get(7), LocalDate.of(2020,03,25), bookItemList2.subList(0,6)),
            new Member("M-009", AccountStatus.BLACKLISTED , personList2.get(8), LocalDate.of(2020,07,30), bookItemList2.subList(0,7)),
            new Member("M-010", AccountStatus.CANCELED, personList2.get(9), LocalDate.of(2020,01,10), bookItemList.subList(0,2))

    );

    // Racks
   //static List <List<Rack>> RackList; - - might need it as List of Arrays/lists
    public static List<Rack> RackList;

    static {
        RackList = new ArrayList<>();
        RackList.add(new Rack(100, "L-01-01", bookItemList.subList(0, 0)));
        RackList.add(new Rack(200, "G-01-01", bookItemList.subList(1, 1)));
    }
    static List<Rack> RackList2;

    static {
        RackList2 = new ArrayList<>();
        RackList2.add(new Rack(100, "L-01-01", bookItemList2.subList(0, 0)));
        RackList2.add(new Rack(200, "G-01-02", bookItemList2.subList(1, 1)));
        RackList2.add(new Rack(300, "G-01-03", bookItemList2.subList(1, 2)));
        RackList2.add(new Rack(400, "G-01-04", bookItemList2.subList(1, 3)));
        RackList2.add(new Rack(500, "G-01-05", bookItemList2.subList(1, 4)));
        RackList2.add(new Rack(600, "G-01-06", bookItemList2.subList(1, 5)));
        RackList2.add(new Rack(700, "G-01-07", bookItemList2.subList(3, 5)));
        RackList2.add(new Rack(800, "G-01-08", bookItemList2.subList(1, 4)));
        RackList2.add(new Rack(900, "G-01-09", bookItemList2.subList(3, 5)));
        RackList2.add(new Rack(110, "G-01-10", bookItemList2.subList(1, 5)));
    }

    public static List<Rack> RackList1;

    static {
        RackList1 = new ArrayList<>();
        RackList1.add(new Rack(100, "L-01-01", bookItemList.subList(0, 2)));
        RackList1.add(new Rack(200, "G-01-01", bookItemList.subList(0, 1)));
    }


    public static List<BookItem> testSpecificBookList = List.of(new BookItem("B-0098-SN-99","Gutten Bend- Auf", "Biology", "Pearson Publishers",
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
                    LocalDate.of(2017,05,01) ));

    public static List<BookItem> testSpecificBookListStartsP = List.of(
            new BookItem("GNB-0098-SN-99","The Good News", "Christianity", "Smartson Publishers",
                    "ARABIC", 8000, authorList.subList(2, 3), "CR-002-01BC",true,
                    230, BookFormat.HARDCOVER,
                    LocalDate.of(2018,12,01),
                    LocalDate.of(2017,05,01) )
    );


}
