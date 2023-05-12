package src;

public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> table = new MyHashTable<String, Integer>();

        table.put("as", 1111);
        table.put("as", 1234);
        System.out.println(table.getKey(1111));

    }
}
