package src;

public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> table = new MyHashTable<String, Integer>();
        table.put("Ask", 123);
        table.put("as", 1111);
        System.out.println(table.get("as"));

    }
}
