import java.io.*;
//import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Task3 {
    
    static JSONArray values_json;
    
    static JSONArray parseArray(JSONArray array) {
        JSONArray new_array = new JSONArray();
        long id;
        for (Object test_obj: array) {
            JSONObject JStest_obj = (JSONObject) test_obj;
            if (JStest_obj.containsKey("value")) {
                id = (long) JStest_obj.get("id");
                for (Object value_obj: values_json) {
                    JSONObject JSvalue_obj = (JSONObject) value_obj;
                    if ((long) JSvalue_obj.get("id") == id) {
                        JStest_obj.put("value", (String) JSvalue_obj.get("value"));
                        break;
                    }
                }
            }
            if (JStest_obj.containsKey("values")) {
                JSONArray values = (JSONArray) JStest_obj.get("values");
                JStest_obj.replace("values", parseArray(values));
            }
            new_array.add(JStest_obj);
        }
        return new_array;
    }
    
    
    public static void main(String [] args) throws Exception {
        JSONParser parser = new JSONParser();
        FileReader values = new FileReader(args[0]);
        FileReader tests = new FileReader(args[1]);
        FileWriter report = new FileWriter("report.json");
        values_json = (JSONArray)((JSONObject) parser.parse(values)).get("values");
        JSONArray tests_json = (JSONArray)((JSONObject) parser.parse(tests)).get("tests");
        
        report.write(parseArray(tests_json).toJSONString());
        
//        Iterator iterator = tests_array.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        
        report.close();
        values.close();
        tests.close();
    }
}
