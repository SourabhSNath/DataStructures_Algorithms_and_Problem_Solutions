package sorting_algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {


        var factorial = getFactorial(2);
        System.out.println(factorial);
    }

    private static int getFactorial(int i) {
        if (i == 0) return 1;
        return i * getFactorial(i - 1);
    }
}