package Map;

import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1, 2, 4, 1, 1 };

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int maxEl = 0;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxEl = entry.getKey();
            }
        }

        for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                if (!e1.getKey().equals(e2.getKey())
                        && e1.getValue().equals(e2.getValue())) {
                    System.out.println(e1.getKey() + " and "
                            + e2.getKey() + " have same frequency "
                            + e1.getValue());
                }
            }
        }

        System.out.println("Max frequency element: " + maxEl);
        System.out.println("Frequency: " + maxFreq);
    }
}
