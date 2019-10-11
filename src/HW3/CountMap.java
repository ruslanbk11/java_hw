import java.util.HashMap;
import java.util.Map;

public class CountMap<K> implements CountMapable<K> {
 
    private Map<K, Integer> hashMap;
 
    public CountMap() {
        this.hashMap = new HashMap<>();
    }
 
    @Override
    public void add(K key) {
        if (hashMap.containsKey(key)){
            hashMap.put(key, hashMap.get(key) + 1);
        } else {
            hashMap.put(key, 1);
        }
    }
 
    @Override
    public void addAll(CountMapable countMapable) {
 
    }
 
    @Override
    public int count(K key) {
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }
        return 0;
    }
 
    @Override
    public Map<K, Integer> asMap(){
        return hashMap;
    }
 
    @Override
    public void copyTo(Map map) {
 
    }
}
