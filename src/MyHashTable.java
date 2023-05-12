package src;

public class MyHashTable<K,V> {
    private class HashNode <K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M){ // This is a constructor for a certain size for
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key){ // generating char from a key
        String strKey = (String) key;
        int sum = 0;
        for(int i = 0; i < strKey.length(); i++){
            sum += strKey.charAt(i);
        }

        return sum % M;
    }
    public void put(K key, V value){ // here I use my hash as an index
        int i = hash(key); // creating the hash (using it as Index)
        HashNode<K,V> node = new HashNode<K,V>(key, value);

        if(chainArray[i] == null){
            chainArray[i] = node; // if there is now elements in the bucket I just add an element to the head
            size++;
        }else{
            HashNode<K,V> currentNode = chainArray[i];
            while(currentNode.next != null){ // if there is an element, traverse to the end and add to the end
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            size++;
        }
    }
    public V get(K key){
        return null;
    }
    public V remove(K key){
        return null;
    }
    public boolean contains(V value){

        return false;
    }
    public K getKey(V value){
        return null;
    }
}
