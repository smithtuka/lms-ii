package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import smith.tukahirwa.functions.FunctionUtil;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static smith.tukahirwa.Tests.Factory.*;


public class FunctionUtilTest {


    @InjectMocks
    Factory factory; // bean creation

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        /*  */
    }

    @Test
    public  void getBookPerCategoryTest() {
        assertEquals(1, FunctionUtil.allBooksPerCategory.apply(Factory.bookItemList, "Literature"));
//        Assert.assertEquals(2, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature").long());
    }

//
// Test 2 - to be cleaned up
    @Test
    public  void topKAuthorsTest() {
        assertEquals(testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));

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

    @Test
    public void getMemberNotBorrow() {
        Map<String, String> map = new HashMap<>();
        map.put("M-002", "Alice Tukahirwa");
        map.put("M-001", "Smith Tukahirwa");
        assertEquals(map, FunctionUtil.getMemberNotBorrow.apply(memberList));
    }

    @Test
    public void pastDueDateBooksTest() {
        assertEquals(new ArrayList<>(), FunctionUtil.pastDueDateBooks.apply(factory.bookItemList));
    }

    @Test
    public void getBookBarcodeTest() {
        assertEquals(factory.bookItemList.subList(0, 1), FunctionUtil.getBookBarcode.apply(factory.memberList, "LT-002-001BC"));
    }

    @Test
    public void getNumberOfBorrowersPastDueTest() {
        assertEquals(1, FunctionUtil.getNumberOfBorrowersPastDue.apply(factory.memberList));
    }

    @Test
    public void getOldestBooksTest() {
        assertEquals(new ArrayList<>(), FunctionUtil.getOldestBooks.apply(factory.bookItemList, 2017));
    }
}
