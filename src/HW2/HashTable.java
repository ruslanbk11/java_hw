package HW2;

public class HashTable {
    private HashTableElement[] array;
    private int length;

    private int getHash(Object key) {
        return Math.abs(key.hashCode()) % this.length;
    }

    public HashTable(int length) {
        this.length = length;
        this.array = new HashTableElement[length];
    }

    public void put(Object key, Object value) {
        HashTableElement tmp = new HashTableElement(key, value);
        int hash = getHash(key);
        if (array[hash] != tmp) {
            for (int i = 0; i < length; i++) {
                int index = (hash + i) % length;
                if(array[index] == null || array[index].deleted) {
                    array[index] = tmp;
                    break;
                } else {
                    //TODO: resize();
                }
            }
        } else {
            System.out.println("Element already exists");
        }
    }

    public Object get(Object key){
        int hash = getHash(key);
        for (int i = 0; i < length; i++) {
            if (array[(hash + i) % length] != null){
                if (array[(hash + i) % length].getKey().equals(key) && !array[(hash + i) % length].deleted) {
                    return array[(hash + i) % length].getValue();
                }
            }
        }
        //System.out.println("Element doesn't exist");
        return null;

    }

    public boolean contains(Object key){
        return get(key) != null;
    }

    public void remove(Object key){
        int hash = getHash(key);
        for (int i = 0; i < length; i++) {
            if (array[(hash + i) % length] != null){
                if (array[(hash + i) % length].getKey().equals(key)) {
                    array[(hash + i) % length].deleted = true;
                }
            }
        }
    }

    public int size() {
        return length;
    }

}