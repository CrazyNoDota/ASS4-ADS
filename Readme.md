# HashTable Implementation in Java

This repository contains an implementation of a HashTable in Java. A HashTable is a data structure that allows for efficient insertion, retrieval, and deletion of key-value pairs.

## MyHashTable

This class represents a HashTable. It uses chaining to handle collisions and implements the following methods:

- `put(key, value)`: Inserts a key-value pair into the HashTable.
- `get(key)`: Retrieves the value associated with the specified key.
- `remove(key)`: Removes the key-value pair with the specified key from the HashTable.
- `contains(value)`: Checks if the HashTable contains the specified value.
- `displayBucketElements()`: Displays the number of elements in each bucket.
- `getKey(value)`: Finds the key associated with the specified value.
- `containsKey(key)`: Checks if the HashTable contains the specified key.

### Usage

1. Create an instance of MyHashTable:

    ```java
    MyHashTable<K, V> hashTable = new MyHashTable<>();
    

2. Insert key-value pairs into the HashTable using the put() method:

   java
   hashTable.put(key, value);


3. Retrieve the value associated with a key using the get() method:

   java
   V value = hashTable.get(key);


4. Remove a key-value pair with a specific key using the remove() method:

   java
   hashTable.remove(key);


5. Check if the HashTable contains a specific value using the contains() method:

   java
   boolean containsValue = hashTable.contains(value);


6. Display the number of elements in each bucket using the displayBucketElements() method:

   java
   hashTable.displayBucketElements();


7. Find the key associated with a specific value using the getKey() method:

   java
   K key = hashTable.getKey(value);


8. Check if the HashTable contains a specific key using the containsKey() method:

   java
   boolean containsKey = hashTable.containsKey(key);


For more details on the implementation and usage, refer to the code and comments in the MyHashTable.java file.
```