package HW3;

import java.util.HashMap;
import java.util.Map;

public class CountMap<K> implements CountMapable<K> {

    private Map<K, Integer> hashMap;

    public CountMap() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public Map<? extends K, ? extends Integer> asMap(){
        return hashMap;
    }

    @Override
    public void toMap(Map<? super K, ? super Integer> map) {
        map.putAll(hashMap);
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
    public int getCount(K key) {
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }
        return 0;
    }

    @Override
    public int remove(K key) {
        if (hashMap.containsKey(key)) {
            return hashMap.remove(key);
        }
        return 0;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public void addAll(CountMap<? extends K> source) {
        Map<? extends K, ? extends Integer> sourceMap = source.asMap();
        for (Map.Entry<? extends K, ? extends Integer> entry : sourceMap.entrySet()) {
            hashMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

}