package solutions.java.random;

import java.util.Arrays;

public class LongestNonDecreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {-1, 3, 4, 5, 2, 2, 2, 2};

        int[] maxLengthStorage = new int[arr.length];
        Arrays.fill(maxLengthStorage, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    maxLengthStorage[i] += Math.max(maxLengthStorage[i], maxLengthStorage[j] + 1);
                }
            }
        }

        int curMax = 0;
        for (int max :
                maxLengthStorage) {
            if (curMax < max) curMax = max;
        }
        System.out.println(curMax);
    }
}
