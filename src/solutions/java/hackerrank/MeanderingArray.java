package solutions.java.hackerrank;

import java.util.*;

public class MeanderingArray {

    /**
     * Sorted as [first largest, first smallest, second largest, second smallest,....]
     */
    private static List<Integer> meanderingArray(List<Integer> unsorted) {

        List<Integer> ascList = new ArrayList<>(unsorted);
        List<Integer> dscList = new ArrayList<>(unsorted);

        ascList.sort(Comparator.naturalOrder());
        dscList.sort(Comparator.reverseOrder());

        List<Integer> meanderingList = new ArrayList<>();
        Iterator<Integer> ascIterator = ascList.iterator();
        Iterator<Integer> dscIterator = dscList.iterator();

        int count = 0;
        while (ascIterator.hasNext() && dscIterator.hasNext()) {
            if (count % 2 != 0) {
                meanderingList.add(ascIterator.next());
            } else {
                meanderingList.add(dscIterator.next());
            }
            count++;
        }

        System.out.println(dscList);
        System.out.println(ascList);

        return meanderingList.subList(0, unsorted.size());
    }

    public static void main(String[] args) {
        List<Integer> unsortedList = Arrays.asList(4, 5, 2, 3, 10, 9, 3, 1);
        System.out.println(meanderingArray(unsortedList));
    }
}
