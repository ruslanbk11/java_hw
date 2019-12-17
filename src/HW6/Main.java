package HW6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        System.out.println(Serializer.toJson(map));
    }
}
