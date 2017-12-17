package json;
import domain.BasicStudent;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BasicStudent basicStudent = new BasicStudent("Hanna", "Gopko", 1);
        JsonObject jsonObject = basicStudent.toJsonObject();

        String expectedJSON = "{'name': 'Hanna', 'surname': 'Gopko', 'year': 1}";
        System.out.println(jsonObject.toJson());
        List<Integer> list = new ArrayList();
        list.add(10);
        list.add(20);
        System.out.println(list.toString());
    }
}
