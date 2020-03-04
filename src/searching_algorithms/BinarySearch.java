package searching_algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 6, 5, 3, 6, 12, 2, 5, 4};

        //It has to be a sorted array
        Arrays.sort(array);

//        System.out.println(binarySearch(array, 3));

        try{
            int i = 100/0;
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Wololowlwowlwowlwowlwowwo");

    }

    private static int binarySearch(int[] array, int i) {
        if (array.length == 0) return -1;
        int start = 0, end = array.length - 1;
        int mid = 0;
        while (start + 1 < end){
            mid = (start + end)/2;
            if (array[mid] == i){
                return mid;
            }else if(array[mid] < i){
                mid = (start + mid-1)/2;
                end = mid;
            }
        }

        return 0;
    }
}
