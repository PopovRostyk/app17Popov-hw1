package json;
import domain.BasicStudent;
import domain.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Andrii",
                "Rodionov",
                3,
                new Tuple<>("OOP", 3),
                new Tuple<>("English", 5),
                new Tuple<>("Math", 2)
        );
        String expectedJSON =
                "{'name': 'Andrii', 'surname': 'Rodionov', 'year': 3, 'exams': [" +
                        "{'course': 'OOP', 'mark': 3, 'passed': true}," +
                        "{'course': 'English', 'mark': 5, 'passed': true}," +
                        "{'course': 'Math', 'mark': 2, 'passed': false}" +
                        "]}";
        System.out.println(expectedJSON);
        System.out.println(student.toJsonObject().toJson());
    }
}
