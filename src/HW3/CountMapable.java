public interface CountMapable<K> {
    void add(K key);
 
    void addAll(CountMapable countMapable);
 
    int count(K key);
 
    Map asMap();
 
    void copyTo(Map<K, ? super Number> map);
}
