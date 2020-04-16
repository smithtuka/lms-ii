package smith.tukahirwa.functions;

// Total amount in fines

import smith.tukahirwa.core.Author;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.core.BookStatus;
import smith.tukahirwa.core.Member;
import smith.tukahirwa.core.BookLending;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

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
           (mList, chargePerday)-> mList.stream()
            .filter(m->m.getBookItems().size()>0)
            .flatMap(m->m.getBookItems().stream())
            .filter(b-> (b.getReturnDate().compareTo(b.getDueDate()))>1)
            .mapToDouble( b-> chargePerday * DAYS.between(b.getDueDate(), b.getReturnDate() ))
                   .sum();

    // Query 4 - books available per Category
    public static final BiFunction<List<BookItem>, String, Long> allBooksPerCategory =
            (bookList, category) -> bookList.stream()
                    .filter(b->b.getSubject()==category)
                    .filter(b->b.getBookStatus()==BookStatus.AVAILABLE)
            .count();

    //Query 23 - top K authors with books borrowed most
    public static final BiFunction<List<BookItem>, Integer, List<Author>> topKAuthors
            = (bookList, k) -> bookList.stream()
            .peek(System.out::println)
            .filter(b->b.getIsReferenceOnly()==false)
            .peek(System.out::println)
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .flatMap(b->b.getAuthors().stream())
            .peek(System.out::println)
            .limit(k)
            .peek(System.out::println)
            .collect(Collectors.toList());






}
