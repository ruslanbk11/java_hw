package HW2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();

        while(scanner.hasNextLine()){
            String string = scanner.nextLine();
            if (string.isEmpty()) { break; }
            String[] str = string.toLowerCase().split(" ");
            for (String s : str) {
                if (map.containsKey(s)) {
                    Integer value = map.get(s) + 1;
                    map.put(s, value);
                } else {
                    map.put(s, 1);
                }
            }
        }

        List<Integer> values = new ArrayList<>(map.values());
        Integer max = -1;
        for (Integer value : values) {
            if (value > max) {
                max = value;
            }
        }
        for (String s : map.keySet()) {
            if(map.get(s).equals(max) && s.length() > 0) {
                System.out.println(s);
            }
        }

        ArrayList arr = new ArrayList(2);
        arr.trimToSize();
        System.out.println(arr.size());
        System.out.println(arr.get(1));
    }
}