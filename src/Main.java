package src;

public class Main {
    public static void main(String[] args){

        TestClass table = new TestClass();
        table.put("al", 123);
        table.put("ja", 1567);
        System.out.println(table.get("al"));

    }
}
