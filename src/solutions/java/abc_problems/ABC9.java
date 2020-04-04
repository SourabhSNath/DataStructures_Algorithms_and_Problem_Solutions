package solutions.java.abc_problems;

public class ABC9 {

    public static void main(String[] args) {


        for (int i = 1; i <= 5; i++) {
            int c = i * (i + 1) / 2;
            for (int j = 0; j < i; j++) {
                System.out.print(String.format("%02d", c) + " ");
                c--;
            }
            System.out.println();

        }

    }
}