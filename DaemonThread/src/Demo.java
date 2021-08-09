import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("test");
        listStr.add("test2");
        listStr.add("test1");
        listStr.add("test3");
        listStr.add("test4");

        List<String> listInte = new ArrayList<>();
        listStr.add("test");
        listStr.add("test2");
        System.out.println(listStr.retainAll(listInte));
    }
}
