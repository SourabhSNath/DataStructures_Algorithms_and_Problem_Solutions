package solutions.java.abc_problems;

public class ABC1 {

    public static void main(String[] args) {
        int value = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {

                if (j != 5)
                    System.out.print(String.format("%02d", value) + "*");
                else System.out.print(String.format("%02d", value));

                value++;
            }
            System.out.println();
        }
    }
}
