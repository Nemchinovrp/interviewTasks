package nemchinovrp.listcastinterface;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.get(1));
        List<Integer> integers = new LinkedList();
        integers.add(1);
        integers.add(2);
        System.out.println(integers.get(-1));
    }
}
