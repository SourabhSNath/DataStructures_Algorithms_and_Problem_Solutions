package solutions.java.abc_problems;

public class ABC3 {

    public static void main(String[] args) {
        int value = 25;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(String.format("%02d", value) + " ");
                value--;
            }
            System.out.println();
        }
    }
}
