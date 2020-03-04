package solutions.java.random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LessThanGiven {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter number");
        var number = scanner.next();

        System.out.println("Enter number to be checked against");
        var y = scanner.nextInt();
        scanner.close();

        var length = number.length();
        var smallerNumbers = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            for (int j = length; j >= i; j--) {

                var small = number.substring(i, j);
                System.out.println(small);
                if (!small.equals("") && Integer.parseInt(small) < y) {
                    smallerNumbers.add(Integer.parseInt(small));
                }

            }
        }

        smallerNumbers.sort(Comparator.naturalOrder());
        System.out.println(smallerNumbers);
    }
}
