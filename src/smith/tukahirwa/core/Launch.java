package smith.tukahirwa.core;

import smith.tukahirwa.Tests.Factory;
import smith.tukahirwa.functions.FunctionUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;


public class Launch {

    public static void main(String[] args) throws IOException {
        // write your code here
        Map<String, Long> map = FunctionUtil.countOfBooksPerPublisher.apply(Factory.bookItemList);
        System.out.println(map);
        Map<String, String> map1 = FunctionUtil.getMemberNotBorrow.apply(Factory.memberList);
        System.out.println(map1);


//        System.out.println(FunctionUtil.authorWithMostBooks.apply(Factory.bookItemList));

        LocalDate ld = LocalDate.of(2018, 12, 1);
        System.out.println(FunctionUtil.bookGivenOnSpecificDate.apply(Factory.bookItemList, ld));
        System.out.println(FunctionUtil.authorStartsWithP.apply(Factory.bookItemList));
        System.out.println(FunctionUtil.getNumOfBooksPerRack.apply(Factory.RackList1));

    }
}
