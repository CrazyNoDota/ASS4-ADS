package src;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> table = new MyHashTable<>();
        table.put("key", 123);
        table.put("jalil", 1111);
        table.resize();
        table.displayBucketElements();
    }
}
