package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonPair extends Tuple<String, Json>{
    private String name;
    private String value;
    public JsonPair(String name, Json value) {
        super(name, value);
        this.name = name;
        this.value = value.toJson();
    }
    public String toJson(){
        return "'" + name + "': " +  value ;
    }
    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}