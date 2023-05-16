package src;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> table = new MyHashTable<>();
        table.put("key", 123);
        System.out.println(table.get("key"));
    }
}
