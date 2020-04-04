package solutions.java.abc_problems;

public class ABCMath {
    public static void main(String[] args) {

        // Question 1
        int c = 1;
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {
                if (i % 2 != 0) {
                    System.out.print(c++);
                } else {
                    System.out.print((c * 2) - j);
                }
            }
            System.out.println();
        }

        System.out.println();

        // Question 2
        c = 0;
        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                c = i * (i + 1) / 2;
                for (int j = 1; j <= i; j++) {
                    System.out.print(c + " ");
                    c--;
                }
            } else {

                c = c + i;
                for (int j = 1; j <= i; j++) {
                    System.out.print(c + " ");
                    c++;
                }

            }
            System.out.println();
        }
    }
}