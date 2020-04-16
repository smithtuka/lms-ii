package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.testng.Assert;
import smith.tukahirwa.functions.FunctionUtil;


import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import smith.tukahirwa.core.BookItem;
import smith.tukahirwa.functions.FunctionUtil;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static smith.tukahirwa.Tests.Factory.*;


public class FunctionUtilTest {


    @InjectMocks
    Factory factory; // bean creation

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void countBooksPerPublisher() {
        Map<String, Long> map = new HashMap<>();
        map.put("Smartson Publishers", (long) 1);
        map.put("Pearson Publishers", (long) 1);
        map.put("MK Publishers Ltd", (long) 1);
        assertEquals(map, FunctionUtil.countOfBooksPerPublisher.apply(bookItemList));
    }

    @Test
    public void countBooksPerCategory() {
        Map<String, Long> map = new HashMap<>();
        map.put("Literature", (long) 1);
        map.put("Biology", (long) 1);
        map.put("Christianity", (long) 1);
        assertEquals(map, FunctionUtil.booksPerCategory.apply(bookItemList));
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
        assertEquals("Gutten Bend- Auf [Timothy Wangusa]", FunctionUtil.topBorrowedBook.apply(factory.bookItemList));
    }

    // Query (21) Get the top k most unborrowed books for the past Y years
    @Test
    public void topUnBorrowedBookTest() {
        assertEquals(factory.bookItemList.subList(0, 1),
                FunctionUtil.topUnBorrowedBook.apply(factory.bookItemList.subList(0, 2), 1, 3));
    }

    // Query (22) Get the month with the most borrowed books and how many books were borrowed
//    @Test
//    public void topMonthCount() {
//        System.out.println();
//        assertEquals(new LinkedHashMap<Month, Integer>(){{put(LocalDate.of(2018,04,01).getMonth(), 2);}},
//                FunctionUtil.topMonthCount.apply(factory.bookItemList.subList(0, 2)));
//    }


    @Test
    public void getMemberNotBorrow() {
        Map<String, String> map = new HashMap<>();
        map.put("M-002", "Alice Tukahirwa");
        map.put("M-001", "Smith Tukahirwa");
        assertEquals(map, FunctionUtil.getMemberNotBorrow.apply(memberList));
    }
    @Test//st1
    public void getBookPerCategoryTest() {
        assertEquals(1, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature"));
    }

    @Test//st2
    public void allBooksPerCategoryTest () {
            assertEquals(1, FunctionUtil.allBooksPerCategory.apply(Factory.bookItemList, "Literature"));
    }
    @Test//st3
    public void topKAuthorsTest () {
            assertEquals(Factory.testAuthors, FunctionUtil.topKAuthors.apply(Factory.bookItemList, 2));
    }
    @Test//st4
    public void averagePriceTest () {
        assertEquals(230, FunctionUtil.averagePrice.apply(Factory.bookItemList, "Literature"));
    }

    @Test
    public void bookGivenOnSpecificDate() {
        LocalDate ld = LocalDate.of(2018,12, 1);
        assertArrayEquals(testSpecificBookList.toArray(), FunctionUtil.bookGivenOnSpecificDate.apply(bookItemList, ld).toArray());
    }

    @Test
    public void authorStartsWithP() {
        assertArrayEquals(testSpecificBookListStartsP.toArray(), FunctionUtil.authorStartsWithP.apply(bookItemList).toArray());
    }

    @Test
    public void getNumOfBooksPerRack() {
        Map<Integer, Long> map = new HashMap<>();
        map.put(100, (long) 2);
        map.put(200, (long) 1);
        assertEquals(map, FunctionUtil.getNumOfBooksPerRack.apply(RackList1));
    }
//
// Test 2 - to be cleaned up
//    @Test
//    public  void topKAuthorsTest() {
//        assertEquals(testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));
//    }

    @Test//st5
    public void stockValueTest () {
            assertEquals(690, FunctionUtil.stockValue.apply(Factory.bookItemList));
    }

    @Test
    public void pastDueDateBooksTest () {
            assertEquals(new ArrayList<>(), FunctionUtil.pastDueDateBooks.apply(factory.bookItemList));
    }

    @Test
        public void getBookBarcodeTest () {
            assertEquals(Factory.bookItemList.subList(0, 1), FunctionUtil.getBookBarcode.apply(Factory.memberList, "LT-002-001BC"));
    }

    @Test
        public void getNumberOfBorrowersPastDueTest () {
            assertEquals(1, FunctionUtil.getNumberOfBorrowersPastDue.apply(Factory.memberList));
    }

    @Test
        public void getOldestBooksTest () {
            assertEquals(new ArrayList<>(), FunctionUtil.getOldestBooks.apply(Factory.bookItemList, 2017));
    }
    }

