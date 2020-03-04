package solutions.java.random;

import java.util.List;

public class VowelDetector {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "Good Morning", "It's Thursday", "That word", "This word", "Intellij");

        for(String words: list){
            System.out.println(getVowelOnly(words));
        }
    }

    /**
     * Solution
     * @param words provided above
     * @return String of vowels
     */
    private static String getVowelOnly(String words) {
        String aeiou = "aeiou";
        StringBuilder stringBuilder = new StringBuilder();
        for(char c: words.toCharArray()){
            if (aeiou.contains(String.valueOf(c).toLowerCase())){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
