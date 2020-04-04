package solutions.java.abc_problems;

public class ABC11 {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 1 || i == 5 || i == j)
                    System.out.print("1 ");
                else if (i < j) System.out.print(" ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        // Weird 
        boolean b = true;
        if (b = false) System.out.println(b);
        else System.out.println("A");
    }
}