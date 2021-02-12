//package com.virak.tdd;
//
//import lombok.extern.slf4j.Slf4j;
////import org.json.JSONArray;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.IOException;
//import java.io.StringWriter;
//
//@Slf4j
//public class UseJsonSimple {
//    public static void main(String[] args) throws IOException, ParseException {
//
//        //Create a JSON object
//        JSONObject obj = new JSONObject();
//
//        obj.put("name", "foo");
//        obj.put("num", 100);
//        obj.put("balance", 1000.21);
//        obj.put("is_vip", true);
//
//        System.out.println(obj);
//        System.out.println(obj.getClass().getName());
//
//        //Converting or streaming obj to a String object (Encoding)
//        StringWriter out = new StringWriter();
//        obj.writeJSONString(out); //out is String Writer type of obj
//        String jsonStr = out.toString();
//        log.info("{}", jsonStr);
//        log.info("{}", jsonStr.getClass().getName());
//
//        //Converting a String object to JSON object or JSONArray Object (Decoding)
//        JSONParser parser = new JSONParser();
//        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
//        JSONArray jsonArrFromS = (JSONArray) parser.parse(s);
//        log.info("{}", jsonArrFromS);
//
//        JSONObject jsonObjfromJsonArr = (JSONObject) jsonArrFromS.get(1);
//        log.info("{}", jsonObjfromJsonArr);
//        JSONObject jsonObjectWithField2 = (JSONObject) jsonObjfromJsonArr.get("1");
//        log.info("{}", jsonObjectWithField2);
//    }
//}
