package smith.tukahirwa.Tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import smith.tukahirwa.functions.FunctionUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static smith.tukahirwa.Tests.Factory.testAuthors;

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


}
