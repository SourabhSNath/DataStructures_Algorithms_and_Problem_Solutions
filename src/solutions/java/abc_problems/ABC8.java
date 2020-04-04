package solutions.java.abc_problems;

public class ABC8 {

    public static void main(String[] args) {

        int neg = -1;
        for (int i = 0; i < 5; i++) {
            int number = 0;
            for (int j = 0; j < 1; j++) {
                System.out.print(neg--);
            }
            for (int j = 0; j < 5; j++) {
                System.out.print(number++);
            }
            System.out.println();

        }
    }
}


