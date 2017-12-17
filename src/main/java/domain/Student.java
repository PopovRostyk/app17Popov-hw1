package domain;

import json.*;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String name;
    private String surname;
    private Integer year;
    private List exams;


    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = new ArrayList<>(Arrays.asList(exams));
    }

    public JsonObject toJsonObject() {
        JsonObject student = new JsonObject();
        return student;
    }
}
