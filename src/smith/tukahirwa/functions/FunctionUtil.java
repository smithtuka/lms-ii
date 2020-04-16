package smith.tukahirwa.functions;

// Total amount in fines


import smith.tukahirwa.core.Author;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.core.BookStatus;
import smith.tukahirwa.core.Member;
import smith.tukahirwa.core.BookLending;
import smith.tukahirwa.core.*;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class FunctionUtil {

    // Query (18) Get bookTitle and ISBN for books borrowed on a specific date
    public static final BiFunction<List<BookItem>, LocalDate, String> booksOnSpecificDay =
            (bList, wantedDay) -> bList.stream()
            .filter(b -> wantedDay.compareTo(b.getBorrowed()) == 0)
            .map(b -> (b.getTitle() +" "+ b.getISBN()))
            .collect(Collectors.joining(","));

    // Query (19) Get the top k most borrowed books for the current month
    public static final BiFunction<List<BookItem>, Integer,  List<BookItem>> topBorrowedBooks =
            (bList, top) -> bList.stream()
            .filter(x -> x.getBorrowed().getMonthValue() == LocalDate.now().getMonthValue())
                    .sorted((a, b) -> b.getCheckOutCounter() - a.getCheckOutCounter())
                    .limit(top)
                    .collect(Collectors.toList());

    // Query (20) Get the book title and the author of the book that is borrowed the most
    public static final Function<List<BookItem>, String> topBorrowedBook =
            (bList) -> bList.stream()
                    .sorted((a, b) -> b.getCheckOutCounter() - a.getCheckOutCounter())
                    .map(x -> x.getTitle() + " " + x.getAuthors().stream().map(a -> a.getName()).collect(Collectors.toList()))
                    .limit(1)
                    .collect(Collectors.joining());


    // Query (21) Get the top k most unborrowed books for the past Y years
    public static final TriFunction<List<BookItem>, Integer, Integer, List<BookItem>> topUnBorrowedBook =
            (bList, topBooks, givenYear) -> bList.stream()
                    .filter(x -> x.getBorrowed().getYear() > LocalDate.now().getYear() - givenYear)
                    .sorted((a, b) -> a.getCheckOutCounter() - b.getCheckOutCounter())
                    .limit(topBooks)
                    .collect(Collectors.toList());

    // Query (22) Get the month with the most borrowed books and how many books were borrowed
    public static final Function<List<BookItem>, LinkedHashMap> topMonthCount =
           (bList) -> bList.stream()
                    .sorted((a,b) -> b.getCheckOutCounter() - a.getCheckOutCounter())
                    .collect(Collectors.groupingBy(
                            x -> x.getBorrowed().getMonth().toString(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    ));





    // Query (a) total Fines accumulated

    public static final BiFunction<List<Member>, Double, Double> totalIncomeInFines =
            (mList, chargePerday) -> mList.stream()
                    .filter(m -> m.getBookItems().size() > 0)
                    .flatMap(m -> m.getBookItems().stream())
                    .filter(b -> (b.getReturnDate().compareTo(b.getDueDate())) > 1)
                    .mapToDouble(b -> chargePerday * DAYS.between(b.getDueDate(), b.getReturnDate()))
                    .sum();

    // Query 3 - books all books per Category
    public static final Function<List<BookItem>, Map<String, Long>> booksPerCategory = (bList) -> bList.stream()
            .collect(Collectors.groupingBy(BookItem::getSubject, Collectors.counting()));

    // Query 4 - books available per Category
    public static final BiFunction<List<BookItem>, String, Long> allBooksPerCategory =
            (bookList, category) -> bookList.stream()
                    .filter(b -> b.getSubject() == category)
                    .filter(b -> b.getBookStatus() == BookStatus.AVAILABLE)
                    .count();

    public static final Function<List<BookItem>, Map<String, Long>> countOfBooksPerPublisher = (bList) -> bList.stream()
            .collect(Collectors.groupingBy(BookItem::getPublisher, Collectors.counting()));

    // Query 17 - get member id and name who has not taken book
    public static final Function<List<Member>, Map<String, String>> getMemberNotBorrow = (mList) -> mList.stream()
            .filter(member -> member.getBookItems().size() == 0)
            .collect(Collectors.toMap(Member::getId, member -> member.getPerson().getName()));


    //Query 23 - top K authors with books borrowed most
    public static final BiFunction<List<BookItem>, Integer, List<Author>> topKAuthors
            = (bookList, k) -> bookList.stream()
//            .peek(System.out::println)
            .filter(b -> b.getIsReferenceOnly() == false)
//            .peek(System.out::println)
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .flatMap(b -> b.getAuthors().stream())
//            .peek(System.out::println)
            .limit(k)
//            .peek(System.out::println)
            .collect(Collectors.toList());

    // Top K subjects - books borrowed most
    public static final BiFunction<List<BookItem>, Integer, List<String>> topKSubjects
            = (bList, k) -> bList.stream()
            .filter(b -> !b.getIsReferenceOnly())
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .limit(k)
            .map(BookItem::getSubject)
            .collect(Collectors.toList());

    // Top k borrowed books grouped per Subject
    public static final BiFunction<List<BookItem>, Integer, Map<String, String>> topKPerCat
            = (bList, k) -> bList.stream()
            .filter(b -> !b.getIsReferenceOnly())
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .limit(k)
            .collect(Collectors.toMap(BookItem::getSubject, BookItem::getTitle));

    // Categories and number of books per category
    public static final Function<List<BookItem>, Map<String, Long>> categoryNumbers =

        (bList)-> bList.stream()
            .collect(Collectors.groupingBy(BookItem::getSubject, Collectors.counting()));

    // total amount of cash in Stocked books
    public static Function<List<BookItem>, Double> stockValue
            = (bList) -> bList.stream()
            .mapToDouble(BookItem::getPrice)
            .sum();

    // Total number of ReferenceOnly vs CheckOut Books
    public static Function<List<BookItem>, Map<Boolean, Long>> ReferenceAndCheckOutBooks
            = (bList) -> bList.stream()
            .collect(Collectors.partitioningBy(BookItem::getIsReferenceOnly, Collectors.counting()));

    // average price of books in a specific category
   public static final BiFunction<List<BookItem>, String, Double> averagePrice
            =(bList, category) -> bList.stream()
            .filter(b->b.getSubject()==category)
            .mapToDouble(BookItem::getPrice)
            .sum();




    // get past due date books
    public static final Function<List<BookItem>, List<BookItem>> pastDueDateBooks =
            bookItems -> bookItems.stream()
                    .filter(bookItem -> bookItem.getReturnDate().compareTo((bookItem.getDueDate())) > 1)
                    .collect(Collectors.toList());
    // get barcode of book
    public static final BiFunction<List<Member>, String, List<String>> getBookBarcode = (members, barcode) ->
            members.stream()
                    .map(member -> member.getBookItems())
                    .map(bookItems -> bookItems.listIterator().next())
                    .map(book -> book.getBarcode())
                    .filter(book -> book.equals(barcode))
//                    .limit(1)
                    .collect(Collectors.toList());
    // Query 7 - get the number of borrowers that have past the due date
    public static final Function<List<Member>, Long> getNumberOfBorrowersPastDue =
            (members) -> members.stream()
                    .filter(m -> m.getBookItems().size() > 0)
                    .flatMap(m -> m.getBookItems().stream())
                    .map(b -> (b.getReturnDate().compareTo(b.getDueDate())) > 1)
                    .count();
    //    get the oldest books ie older than K years, sorted by Publication dates
    public static final BiFunction<List<BookItem>, Integer, List<String>> getOldestBooks = (books, k) ->
            books.stream()
                    .filter(b -> (LocalDate.now().minus(k, ChronoUnit.YEARS)).compareTo(b.getPublicationDate()) > 1)
                    .sorted(Comparator.comparing(BookItem::getPublicationDate).reversed())
                    .map(BookItem::getTitle)
                    .collect(Collectors.toList());

  /*  // total amount of cash in Stocked books
    public static Function<List<BookItem>, Double> stockValue
            = (bList) -> bList.stream()
            .mapToDouble(BookItem::getPrice)
            .sum();
    // Total number of ReferenceOnly vs CheckOut Books
    public static Function<List<BookItem>, Map<Boolean, Long>> ReferenceAndCheckOutBooks
            = (bList) -> bList.stream()
            .collect(Collectors.partitioningBy(BookItem::getIsReferenceOnly, Collectors.counting()));
    // average price of each books in a specific category
    BiFunction<List<BookItem>, String, Double> averagePrice
            = (bList, category) -> bList.stream()
            .filter(b -> b.getSubject() == category)
            .mapToDouble(BookItem::getPrice)
            .sum();*/

    //Query 27 - books whose authors start with p
    public static  final BiFunction<BookItem, String, Boolean> startsP = ((bookItem, s) -> Stream.of(bookItem)
            .flatMap(b -> b.getAuthors().stream()).flatMap(author -> Stream.of(author.getName()))
            .anyMatch(name -> name.toLowerCase().startsWith(s.toLowerCase())));

    public static  final Function<List<BookItem>,List<Book>>authorStartsWithP
            =(bookItems) -> bookItems.stream()
            .filter(b-> startsP.apply(b, "p"))
            .collect(Collectors.toList());

    //Query 28 - get rack number and the number of books in each rack
    public static final Function<List<Rack>, Map<Integer, Long>> getNumOfBooksPerRack = (racks) -> racks.stream()
            .collect(Collectors.toMap(Rack::getNumber, (rack) -> (long) rack.getBooks().size()));

    //Query 30 - get books which are purchased on the date "day/month/year"
    public static final BiFunction<List<BookItem>, LocalDate,List<Book>> bookGivenOnSpecificDate=
            (bookItems, date)->bookItems.stream()
            .filter(d->d.getDateOfPurchase().compareTo(date) == 0).collect(Collectors.toList());

}
