package domain;

import json.*;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private ArrayList<Tuple<String, Integer>> examList = new ArrayList<>();


    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        examList.addAll(Arrays.asList(exams));
    }
    public JsonObject toJsonObject() {
        boolean passed;
        JsonPair jsonPair_name = new JsonPair("name", new JsonString(name));
        JsonPair jsonPair_surname = new JsonPair("surname", new JsonString(surname));
        JsonPair jsonPair_year = new JsonPair("year", new JsonNumber(year));
        JsonObject student = new JsonObject(jsonPair_name, jsonPair_surname, jsonPair_year);
        JsonObject[] examsListJson = new JsonObject[examList.size()];
        for (int i = 0; i < examsListJson.length; i++) {
            passed = examList.get(i).value > 2;
            examsListJson[i] = new JsonObject(
                    new JsonPair("course", new JsonString((String) examList.get(i).key)),
                    new JsonPair("mark", new JsonNumber((Number) examList.get(i).value)),
                    new JsonPair("passed", new JsonBoolean(passed)));
        }
        JsonArray jsonArray = new JsonArray(examsListJson);
        student.add(new JsonPair("exams", jsonArray));
        return student;
    }
}
