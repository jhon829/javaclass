import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        String [] animals = {"tiger", "monkey", "rabbit", "snake"};

        List<String> list = new ArrayList<String>();

//        for(int i = 0; i < animals.length; i++){
//            list.add(anilmals[i]);
//        }

        for(String v : animals){
            list.add(v);
        }
        System.out.println(list.indexOf("monkey"));
        System.out.println(list.contains("rabbit"));

    }
}
