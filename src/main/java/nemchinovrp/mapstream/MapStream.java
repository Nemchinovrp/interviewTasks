package nemchinovrp.mapstream;

import java.util.HashMap;
import java.util.Map;

public class MapStream {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.entrySet()
                .stream()
                .forEach(e -> System.out.println(
                "Key: " + e.getKey() + " - Value: " + e.getValue()));
    }
}
