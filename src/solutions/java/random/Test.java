package solutions.java.random;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        var sCount = scanner.nextInt();
        var students = new ArrayList<Integer>();


        for (int i = 0; i < sCount; i++) {
            students.add(scanner.nextInt());
        }


        var maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < sCount; i++) {

            var currentValue = students.get(i);
            if (maxValue <= currentValue) {
                maxValue = currentValue;
                System.out.println(0);
            }else {
                System.out.println(i);
            }
        }
    }
}