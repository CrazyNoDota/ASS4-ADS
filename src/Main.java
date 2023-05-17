package src;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args){
        MyHashTable table = new MyHashTable();
        table.put("jalil", 123);
        System.out.println(table.containsKey("jalkjil"));
    }
}
