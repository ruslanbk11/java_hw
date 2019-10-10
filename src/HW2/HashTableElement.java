package HW2;

public class HashTableElement {
    private Object key;
    private Object value;
    public boolean deleted;

    public HashTableElement(Object key, Object value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
