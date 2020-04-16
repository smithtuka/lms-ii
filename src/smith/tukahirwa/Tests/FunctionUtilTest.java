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
        /*  */
    }

    @Test//1
    public  void allBooksPerCategoryTest() {
        assertEquals(1, FunctionUtil.allBooksPerCategory.apply(factory.bookItemList, "Literature"));
    }
    @Test//1
    public  void topKAuthorsTest() {
        assertEquals(factory.testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));
    }
    @Test//1
    public void  averagePriceTest(){
        assertEquals(230, FunctionUtil.averagePrice.apply(factory.bookItemList, "Literature"));
    }
    @Test//1
    public void stockValueTest(){
        assertEquals(690, FunctionUtil.stockValue.apply(factory.bookItemList));
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
