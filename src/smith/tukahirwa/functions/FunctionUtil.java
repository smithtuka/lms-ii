package smith.tukahirwa.functions;

// Total amount in fines

import smith.tukahirwa.core.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class FunctionUtil {


    // Query (1a) total amount accumulated in Fines

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

     // Query 11: The most frequent borrower
     public static final Function< List<Member>, Optional<Member>> mostFrequentBorrower
             = memberList -> memberList.stream()
             .sorted((m1, m2) -> m2.getTotalBooksCheckedout() - m1.getTotalBooksCheckedout()).findFirst();

     // Query 12: titles that have been borrowed to a specific member
    public static final Function< List<Member>, List<String>> infoAboutBorrowedBook
            = memberList -> memberList.stream()
             .flatMap(m->m.getBookItems().stream())
             .map(BookItem::getTitle)
             .collect(Collectors.toList());

    //Query 13: The list of blacklist members
    public static final Function< List<Member>, List<Member>> blacklistedMember
            = memberList -> memberList.stream()
            .filter(m -> m.getStatus().equals(AccountStatus.BLACKLISTED))
            .collect(Collectors.toList());


}
