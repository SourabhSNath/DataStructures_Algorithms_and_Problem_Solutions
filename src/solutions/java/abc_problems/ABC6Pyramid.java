package solutions.java.abc_problems;

public class ABC6Pyramid {
    public static void main(String[] args) {

        int val = 1;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print(String.format("%02d", val) + " ");
                val++;
            }
            System.out.println();
        }
    }
}