import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Map<String, Integer> map = SimpleProxy.cache(new HashMap<>());
        System.out.println(map.containsKey("Privet"));
        System.out.println(map.put("Privet", 534));
        System.out.println(map.containsValue(534));
    }
}
