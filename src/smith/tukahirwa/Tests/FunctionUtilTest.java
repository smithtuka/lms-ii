package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.functions.FunctionUtil;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static smith.tukahirwa.Tests.Factory.testAuthors;

public class FunctionUtilTest {


    @InjectMocks
    Factory factory; // bean creation

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

    }
    // Query (18) Get bookTitle and ISBN for books borrowed on a specific date
    @Test
    public void booksOnSpecificDayTest() {
        String[] trial = new String[]{"The Lion & the Jew B-0098-SN-98"};
        assertEquals(trial[0], FunctionUtil.booksOnSpecificDay.apply(factory.bookItemList.subList(0, 2), LocalDate.of(2018,04,01)));
    }

    // Query (19) Get the top k most borrowed books for the current month
    @Test
    public void topBorrowedBooksTest() {
        assertEquals(new ArrayList<>(factory.bookItemList.subList(1, 2)), FunctionUtil.topBorrowedBooks.apply(factory.bookItemList.subList(0, 2), 1));
    }

    // Query (20) Get the book title and the author of the book that is borrowed the most
    @Test
    public void topBorrowedBookTest() {
        assertEquals("Gutten Bend- Auf [Polpot King]", FunctionUtil.topBorrowedBook.apply(factory.bookItemList));
    }

    // Query (21) Get the top k most unborrowed books for the past Y years
    @Test
    public void topUnBorrowedBookTest() {
        assertEquals(factory.bookItemList.subList(0, 1),
                FunctionUtil.topUnBorrowedBook.apply(factory.bookItemList.subList(0, 2), 1, 3));
    }

    // Query (22) Get the month with the most borrowed books and how many books were borrowed
    @Test
    public void topMonthCount() {
        assertEquals(new LinkedHashMap<String, Integer>(){{put(LocalDate.of(2018,04,01).getMonth().toString(), 2);}},
                FunctionUtil.topMonthCount.apply(factory.bookItemList.subList(0, 2)));
    }

    @Test
    public  void allBooksPerCategoryTest() {
        assertEquals(1, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature"));
//        Assert.assertEquals(2, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature").long());
    }

 //Test 2 to be cleaned up
    @Test
    public  void topKAuthorsTest() {
        assertEquals(testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));
    }


}
