package lambda;

import java.util.ArrayList;
import java.util.List;

public class SortingStrings {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.add("kumar");
        stringList.add("ankit");
        stringList.add("smita");
        stringList.add("nitish");
        stringList.add("jyoti");
        stringList.add("abhinav");

        stringList.sort(((s1, s2) -> s1.compareTo(s2)));
        System.out.println(stringList);

        stringList.sort(((s1, s2) -> s2.compareTo(s1)));
        System.out.println(stringList);
    }
}
