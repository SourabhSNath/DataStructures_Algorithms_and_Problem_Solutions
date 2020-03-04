package solutions.java.abc_problems;

public class ABC4 {
    public static void main(String[] args) {

        int i = 1;
        int o = 0;

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
//                System.out.println(j % 2);

                if (j % 2 == 0) {
                    System.out.print(i);
                } else
                    System.out.print(o);
            }
            System.out.println();
        }
    }
}
