package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeIf(n -> (n % 2 == 0));

        System.out.println(list);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        linkedList.removeIf(node -> (node % 2 == 0));

        System.out.println(linkedList);
    }
}
