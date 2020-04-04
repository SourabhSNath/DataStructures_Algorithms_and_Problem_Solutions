package solutions.java.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateWords {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A string with a duplicate");
        strings.add("This string doesn't hava a duplicate");
        strings.add("Row, row, row your boat");
        strings.add("Here is a here is a here");
        strings.add("Meow, meow. meeeoew meow, meow");


        for (String s : strings) {
            var stringArray = s.split(" ");

            var map = new HashMap<String, Integer>();
            for (String word : stringArray) {
                map.merge(word.toLowerCase().replaceAll("[^a-zA-Z]", ""), 1, Integer::sum);
            }

            System.out.println(map);
        }
    }
}