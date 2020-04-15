package smith.tukahirwa.functions;

// Total amount in fines

import smith.tukahirwa.core.Author;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.core.BookStatus;
import smith.tukahirwa.core.Member;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
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






}
