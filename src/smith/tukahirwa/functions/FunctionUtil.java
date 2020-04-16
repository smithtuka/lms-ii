package smith.tukahirwa.functions;

// Total amount in fines

import smith.tukahirwa.core.Author;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.core.BookStatus;
import smith.tukahirwa.core.Member;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class FunctionUtil {


    // Query (1a) total amount accumulated in Fines

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
//            .peek(System.out::println)
            .filter(b->b.getIsReferenceOnly()==false)
//            .peek(System.out::println)
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .flatMap(b->b.getAuthors().stream())
//            .peek(System.out::println)
            .limit(k)
//            .peek(System.out::println)
            .collect(Collectors.toList());

    // Top K subjects - books borrowed most
    public static final BiFunction<List<BookItem>, Integer, List<String>> topKSubjects
            = (bList, k) -> bList.stream()
            .filter(b->!b.getIsReferenceOnly())
            .sorted(Comparator.comparing(BookItem::getCheckOutCounter))
            .limit(k)
            .map(BookItem::getSubject)
            .collect(Collectors.toList());

    // Top k borrowed books grouped per Subject
    public static final BiFunction<List<BookItem>, Integer, Map<String, String>> topKPerCat
            = (bList, k) -> bList.stream()
            .filter(b->!b.getIsReferenceOnly())
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





}
