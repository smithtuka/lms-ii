package smith.tukahirwa.core;

import com.google.gson.Gson;
import smith.tukahirwa.Tests.Factory;
import smith.tukahirwa.functions.FunctionUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Launch {

    public static void main(String[] args) throws IOException {
	// write your code here
        Map<String, Long> map = FunctionUtil.countOfBooksPerPublisher.apply(Factory.bookItemList);
       System.out.println(map);
       Map<String, String> map1 = FunctionUtil.getMemberNotBorrow.apply(Factory.memberList);
       System.out.println(map1);


    }
}
