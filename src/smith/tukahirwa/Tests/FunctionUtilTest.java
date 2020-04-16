package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import smith.tukahirwa.functions.FunctionUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static smith.tukahirwa.Tests.Factory.testAuthors;

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
        assertEquals(testAuthors, FunctionUtil.topKAuthors.apply(factory.bookItemList, 2));
    }
    @Test//1
    public void  averagePriceTest(){
        assertEquals(230, FunctionUtil.averagePrice.apply(factory.bookItemList, "Literature"));
    }
    @Test//1
    public void stockValueTest(){
        assertEquals(690, FunctionUtil.stockValue.apply(factory.bookItemList));
    }



}
