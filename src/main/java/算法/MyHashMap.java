package 算法;


//高频面试题：手写简易HashMap类
public class MyHashMap<K, V> {
    private int CAPACITY = 16;
    private int size = 0;
    private Entry[] table;

    public MyHashMap(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.table = new Entry[CAPACITY];
    }

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public V put(K key, V value) {
        if (key == null) return putForNullKey(value);
        int hash = myHash(key);
        int i = indexForTable(hash, CAPACITY);

        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key))) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, i);

        return null;
    }

    public V get(K key) {
        if (key == null)
            return getForNullKey();

        int hash = myHash(key);
        int i = indexForTable(hash, CAPACITY);

        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key)))
                return e.value;
        }

        return null;
    }

    private V getForNullKey() {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

    private void addEntry(int hash, K key, V value, int i) {
        Entry<K, V> e = table[i];
        table[i] = new Entry<K, V>(hash, key, value, e);
        if (size == CAPACITY)
            resize();

        size++;
    }

    private void resize() {
        CAPACITY= CAPACITY* 2;
        Entry[] newtable = new Entry[CAPACITY];
        for (Entry<K, V> entry : table) {
            Entry<K, V> e = entry; // 取得旧Entry数组的每个元素
            if (e != null) {
                entry = null;// 释放旧Entry数组的对象引用（循环后，旧的Entry数组不再引用任何对象）
                do {
                    Entry<K, V> next = e.next;
                    int i = indexForTable(e.hash, CAPACITY); // 重新计算每个元素在数组中的位置
                    e.next = newtable[i];
                    newtable[i] = e; // 将元素放在数组上
                    e = next; // 访问下一个Entry链上的元素
                } while (e != null);
            }
        }
        table = newtable;
    }

    private int indexForTable(int hash, int CAPACITY) {
        return hash & (CAPACITY - 1);
    }

    private int myHash(K key) {
        if (key == null)
            return 0;

        int h = key.hashCode();
        h = h ^ (h >>> 16);

        return h;
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        addEntry(0, null, value, 0);

        return null;
    }


    private static class Entry<K, V> {
        public int hash;
        public K key;
        public V value;
        public Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

