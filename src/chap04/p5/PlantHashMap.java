package chap04.p5;

public class PlantHashMap<K, V> {
    private static int CAPACITY = 16;
    private Entry<K, V>[] bucket = new Entry[CAPACITY];

    public void put(K key, V value) {
        int index = hashCode(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        bucket[index] = newEntry;
        System.out.println("\'" + newEntry.getKey() + "\' 추가 : \'" + newEntry.getValue() + "\'");
    }

    public void get(K key) {
        int index = hashCode(key);
        Entry<K, V> searchedPlant = bucket[index];
        System.out.println("\'" + key + "\' 검색 : \'" + searchedPlant.getValue() + "\'");
    }

    public void getIndex(K key) {
        int index = hashCode(key);
        System.out.println("\'" + key + "\' 인덱스 : " + index);
    }

    private int hashCode(K key) {
        return key.hashCode() % CAPACITY;
    }

    public void remove(K key) {
        int index = hashCode(key);
        bucket[index] = null;
        System.out.println("\'" + key + "\' 삭제 : \'" + key + "\'와 그 특징이 삭제되었습니다.");
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
