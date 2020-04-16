package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import smith.tukahirwa.functions.FunctionUtil;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionUtilTest {


    @InjectMocks
    Factory factory; // bean creation

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public  void allBooksPerCategoryTest() {
        assertEquals(1, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature"));
//        Assert.assertEquals(2, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature").long());
    }
//
// Test 2 - to be cleaned up
//    @Test
//    public  void topKAuthorsTest() {
//        assertEquals(testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));
//    }

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
