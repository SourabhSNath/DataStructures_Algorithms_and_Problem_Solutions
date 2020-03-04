package solutions.java.abc_problems;

public class Abc2 {
    public static void main(String[] args) {

        int value = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(value + "\t");
                value++;
            }
            System.out.println();
        }
    }
}
