package se.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
  public static void main(String[] args){
    List<String> lst1 = new ArrayList<>(Arrays.asList("a", "t", "b", "u", "p", "x"));
    List<String> lst2 = new ArrayList<>(Arrays.asList("a", "c", "w", "u", "g", "x"));

    lst1.retainAll(lst2);
    System.out.println(lst1);
    System.out.println(4 >> 2);
  }
}
