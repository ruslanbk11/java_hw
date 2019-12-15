package HW3;

import java.util.Map;

public interface CountMapable<K> {

    void add(K key);

    int getCount(K key);

    int remove(K key);

    int size();

    void addAll(CountMap<? extends K> source);

    Map<? extends K, ? extends Integer> asMap();

    void toMap(Map<? super K, ? super Integer> map);
}
