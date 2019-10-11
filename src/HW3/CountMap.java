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
    public void addAll(CountMap<K> countMap) {
        for (K k : countMap.hashMap.keySet()) {
            if (hashMap.containsKey(k)){
                map.put(k, countMap.getCount(k) + hashMap.get(k));
            } else {
                map.put(k, countMap.getCount(k));
            }
        }
    }

    @Override
    public int getCount(K key) {
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }
        return 0;
    }

    @Override
    public int remove(K key) {
        if (hashMap.containsKey(key)){
            return hashMap.remove(key);
        }
        return 0;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public Map<K, Integer> asMap(){
        return hashMap;
    }

    @Override
    public void copyTo(Map<K, Integer> map) {
        for (K k : hashMap.keySet()) {
            if (map.containsKey(k)){
                map.put(k, map.get(k) + hashMap.get(k));
            } else {
                map.put(k, hashMap.get(k));
            }
        }
    }
}
