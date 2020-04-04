package solutions.java.abc_problems;

public class ABC10 {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5; j++) {
                if (i % 2 != 0) {

                    if (j < 5) System.out.print(i);
                    else System.out.print(i + 1);

                } else {

                    if (j == 1) System.out.print(i + 1);
                    else System.out.print(i);

                }
            }
            System.out.println();
        }

        System.out.println();

        // METHOD 2
        for (int i = 1; i <= 5; i++) {

            if (i % 2 == 0) {
                System.out.print(i + 1);
            }
            for (int j = 1; j <= 4; j++) {
                System.out.print(i);
            }
            if (i % 2 != 0) {
                System.out.print(i + 1);
            }

            System.out.println();

        }
    }
}