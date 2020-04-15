package demo.javase.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
  public static void test1(){

    Map<String, Integer> map = new HashMap<>();
    map.put("good", 1);
    map.put("morning", 2);
    map.put("running", 10);
    map.put("hello", 100);

    Integer good = map.remove("good");
    System.out.println(good);

    Integer morning = map.get("morning");
    System.out.println(morning);

    map.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });
  }

  public static void test2(){

    Map<String, Integer> map = new LinkedHashMap<String, Integer>(){
      @Override
      protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > 3;
      }
    };
    map.put("good", 1);
    map.put("morning", 2);
    map.put("running", 10);
    map.put("hello", 100);
    map.put("running", 20);

//    Integer good = map.remove("good");
//    System.out.println(good);
//
//    Integer morning = map.get("morning");
//    System.out.println(morning);

    map.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });
  }

  public static void main(String[] args) {
//    test1();
    test2();
  }
}
