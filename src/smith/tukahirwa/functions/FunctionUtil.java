package smith.tukahirwa.functions;

// Total amount in fines

import smith.tukahirwa.core.Author;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.core.BookStatus;
import smith.tukahirwa.core.Member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class FunctionUtil {


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

    // get past due date books
    public static final Function<List<BookItem>, List<BookItem>> pastDueDateBooks =
            bookItems -> bookItems.stream()
                    .filter(bookItem -> bookItem.getReturnDate().compareTo((bookItem.getDueDate())) > 1 )
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
            (members)-> members.stream()
                    .filter(m->m.getBookItems().size()>0)
                    .flatMap(m->m.getBookItems().stream())
                    .map(b -> (b.getReturnDate().compareTo(b.getDueDate())) > 1)
                    .count();

//    get the oldest books ie older than K years, sorted by Publication dates
    public static final BiFunction<List<BookItem>, Integer, List<String>> getOldestBooks = (books, k) ->
        books.stream()
                .filter( b-> ( LocalDate.now().minus(k, ChronoUnit.YEARS) ).compareTo(b.getPublicationDate())>1 )
                .sorted(Comparator.comparing(BookItem::getPublicationDate).reversed())
                .map(BookItem::getTitle)
                .collect(Collectors.toList());

}
