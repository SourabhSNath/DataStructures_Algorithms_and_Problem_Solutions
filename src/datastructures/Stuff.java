package datastructures;

public class Stuff {
    public static void main(String[] args) {

        int x = -89;
        int a = 5;
        int hex = 0x7FFFFFFF;

        System.out.println("X Negative int to binary: " + Integer.toBinaryString(x) + " HexDecimal: " + Integer.toBinaryString(hex));
        System.out.println("X positive int to binary: " + Integer.toBinaryString(x * ((x < 0) ? -1 : 1)));

        System.out.println(Integer.toBinaryString(x & hex));
        System.out.println("Bitwise output " + (x & hex));
        System.out.println("Bitwise output2 " + (x & Integer.MAX_VALUE));
        System.out.println((x & hex) % a);

        //
        System.out.println(Integer.toBinaryString(5) + " & " + Integer.toBinaryString(a));
        System.out.println(5 & a);
    }
}
