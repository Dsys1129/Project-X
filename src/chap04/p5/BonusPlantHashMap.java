package chap04.p5;

import java.util.LinkedList;

public class BonusPlantHashMap<K, V> {
    private static int CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public BonusPlantHashMap() {
        buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = hashCode(key);
        LinkedList<Entry<K, V>> slots = buckets[index];
        for (Entry<K, V> entry : slots) {
            // 이미 같은 키가 있다면 value 업데이트
            if (entry.key.equals(key)) {
                entry.value = value;
                System.out.println("\'" + entry.getKey() + "\'의 값을 업데이트 했습니다.");
                return;
            }
        }

        // slot에 추가
        Entry<K, V> newEntry = new Entry<>(key, value);
        slots.add(newEntry);
        System.out.println("\'" + newEntry.getKey() + "\' 추가 : \'" + newEntry.getValue() + "\'");
    }

    public void get(K key) {
        int index = hashCode(key);
        LinkedList<Entry<K, V>> slots = buckets[index];

        for (Entry<K, V> entry : slots) {
            if (entry.getKey().equals(key)) {
                System.out.println("\'" + key + "\' 검색 : \'" + entry.getValue() + "\'");
                return;
            }
        }
        System.out.println("해당하는 key가 없습니다.");
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
        LinkedList<Entry<K, V>> slots = buckets[index];
        for (Entry<K, V> entry : slots) {
            if (entry.getKey().equals(key)){
                slots.remove(entry);
                System.out.println("\'" + key + "\' 삭제 : \'" + key + "\'와 그 특징이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당하는 키가 없습니다.");
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
