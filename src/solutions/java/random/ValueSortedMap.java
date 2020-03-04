package solutions.java.random;

import java.util.*;

public class ValueSortedMap {

    static int[] numbers = {1, 2, 3, 4, 5, 2, 2, 2, 1, 1, 1, 1, 1, 7, 7, 5};

    public static void main(String[] args) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int number : numbers) {
            int count = 0;
            for (int val : numbers) {
                if (number == val)
                    map.put(number, ++count);
            }
        }

        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));

        System.out.println(mapList);

        map.clear();
        mapList.forEach(e -> map.put(e.getKey(), e.getValue()));

        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        for (int val : map.keySet()) {
            System.out.print(val);
            for (int i = 0; i < map.get(val); i++) {
                list.add(val);
            }
        }

        int[] new_ar = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(new_ar));
    }
}
