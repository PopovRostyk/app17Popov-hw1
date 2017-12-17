package json;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairList;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairList = new ArrayList<JsonPair>(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        return "{" + getJsonBody() + "}";
    }

    public void add(JsonPair jsonPair) {
        jsonPairList.add(jsonPair);
    }

    public Json find(String name) {
        Json match_item = null;
        for (JsonPair pair : jsonPairList) {
            if (Objects.equals(pair.getName(), name)){
                match_item = new JsonString(pair.getValue());
                break;
            }
        }
        return match_item;
    }
    private String getJsonBody(){
        String jsonStr = "";
        Iterator<JsonPair> jsonIterator = jsonPairList.iterator();
        while (jsonIterator.hasNext()) {
            JsonPair json = jsonIterator.next();
            jsonStr += json.toJson();
            if (jsonIterator.hasNext())
                jsonStr += ", ";
        }
        return jsonStr;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name : names) {
            if (this.find(name) != null){
                JsonPair jsonPair = new JsonPair(name, this.find(name));
                jsonObject.add(jsonPair);
            }
            //JsonPair jsonPair = new JsonPair(name, this.find(name));
            //if (jsonPair.getValue() != null){jsonObject.add(jsonPair);}
        }
        return jsonObject;
    }
}
