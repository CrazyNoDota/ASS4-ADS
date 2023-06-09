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
    private int M = 1000000;
    private int size;
    private double loadFactor = 0.7; // Set the load factor to 0.7 (70%)
    private int threshold; // Threshold for resizing

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
        threshold = (int)(M * loadFactor);
    }
    public MyHashTable(int M){ // This is a constructor for a certain size for
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
        threshold = (int)(M * loadFactor);
    }
    public void resize() {
        int newM = M * 2; // Double the size of chainArray
        HashNode<K, V>[] newChainArray = new HashNode[newM];

        // Rehash all elements to the new chainArray
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                int newIndex = hash(currentNode.key) % newM;
                HashNode<K, V> newNode = new HashNode<>(currentNode.key, currentNode.value);
                if (newChainArray[newIndex] == null) {
                    newChainArray[newIndex] = newNode;
                } else {
                    HashNode<K, V> current = newChainArray[newIndex];
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
                currentNode = currentNode.next;
            }
        }

        // Update chainArray and threshold with the new values
        chainArray = newChainArray;
        M = newM;
        threshold = (int)(M * loadFactor);
    }
    private int hash(K key){ // generating char from a key
        int hashCode = 0;

        // Generating the hash code from the key
        for (char c : key.toString().toCharArray()) {
            hashCode = 31 * hashCode + c;
        }

        return Math.abs(hashCode % M);
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

            if (size >= threshold) {
                resize(); // Resize the chainArray if the size exceeds the threshold
            }
        }

    }
    public V get(K key){
        int i = hash(key); // identifying the index of chain array (hash)
        if(chainArray[i] == null){
            return null;
        }else{
            HashNode<K,V> currentNode = chainArray[i]; // the head of bucket
            if(currentNode.key.equals(key)){ // if the head is the element we need
                return currentNode.value;
            }
            while (currentNode != null) { // traversing the bucket
                if(currentNode.key.equals(key)){
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
    public V remove(K key){ // the code to remove an object from chain array
        int i = hash(key); // generating hash
        if(chainArray[i] == null){
            throw new IndexOutOfBoundsException("There is no such key"); // if there is no key that we want to delete then error
        }else{
            HashNode<K,V> currentNode = chainArray[i];
            if(currentNode.key.equals(key)){
                chainArray[i] = currentNode.next; // if it is first element
            }else{
                HashNode<K,V> previousNode = currentNode;
                while(currentNode != null){ // traversing the bucket
                    if(currentNode.key.equals(key)){
                        previousNode.next = currentNode.next;
                    }
                    previousNode = currentNode;
                    currentNode = currentNode.next;

                }
            }
        }
        return null;
    }
    public boolean contains(V value){
        for(int i = 0; i < chainArray.length; i++){ // traversing through all buckets
            if(chainArray[i] == null){
                continue;
            }
            HashNode<K,V> currentNode = chainArray[i];
            if(currentNode.value.equals(value)){
                return true;
            }else{
                while (currentNode.next != null){ // traversing through particular bucket(linked list) elements
                    if(currentNode.value.equals(value)){
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            }

        }
        return false;
    }
    public void displayBucketElements() {
        int[] bucketCounts = new int[M];

        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            HashNode<K,V> currentNode = chainArray[i];

            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }

            bucketCounts[i] = count;
        }

        // Display the number of elements in each bucket
        for (int i = 0; i < bucketCounts.length; i++) {
            if(bucketCounts[i] != 0)
            System.out.println("Bucket " + i + ": " + bucketCounts[i] + " elements");
        }
    }

    public K getKey(V value){ // finding key by value
        for(int i = 0; i < chainArray.length; i++){ // traversing through buckets
            if(chainArray[i] == null){ // if it is null there is no value
                continue;
            }
            if (chainArray[i].value.equals(value)){
                return chainArray[i].key;
            }
            HashNode<K,V> currentNode = chainArray[i];
            while (currentNode != null){ // traversing through one bucket
                if(currentNode.value.equals(value)){
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        int i = hash(key);
        if(chainArray[i] != null){
            HashNode currentNode = chainArray[i];
            while(currentNode != null){
                if(currentNode.key.equals(key)){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
}
