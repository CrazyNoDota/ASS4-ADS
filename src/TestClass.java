package src;

public class TestClass<K,V> {
    private class HashNode <K,V>{
        K key;
        V value;
        HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public TestClass(){
        chainArray = new HashNode[M];
    }

    public TestClass(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key){
        String strKey = (String) key;
        int sum = 0;
        for(int i=0; i<strKey.length(); i++){
            sum += strKey.charAt(i);
            sum*=31;
        }
        return sum % M;
    }

    public void put(K key, V value){
        int i = hash(key);
        for (HashNode<K, V> x = chainArray[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        HashNode<K,V> node = new HashNode<K,V>(key,value);
        node.next = chainArray[i];
        chainArray[i] = node;
        size++;
    }

    public V get(K key){
        int i = hash(key);
        for (HashNode<K, V> x = chainArray[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public V remove(K key){
        int i = hash(key);
        HashNode<K, V> prev = null;
        for (HashNode<K, V> x = chainArray[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                if (prev != null) {
                    prev.next = x.next;
                } else {
                    chainArray[i] = x.next;
                }
                size--;
                return x.value;
            }
            prev = x;
        }
        return null;
    }

    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> x = chainArray[i]; x != null; x = x.next) {
                if (value.equals(x.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> x = chainArray[i]; x != null; x = x.next) {
                if (value.equals(x.value)) {
                    return x.key;
                }
            }
        }
        return null;
    }
}