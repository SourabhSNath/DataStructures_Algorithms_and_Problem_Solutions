package solutions.java.abc_problems;

public class Abc7 {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            int val = i;

            for (int j = 1; j < 5; j++) {
                System.out.print(String.format("%02d", val) + " ");
                val +=5;
            }
            System.out.println();
        }
    }
}
