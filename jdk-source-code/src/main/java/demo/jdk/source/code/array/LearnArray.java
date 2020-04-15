package demo.jdk.source.code.array;

import java.lang.reflect.Array;

public class LearnArray {
  int[] ints;
  Array array;
  public static void main(String[] args) {
    String intArrayClassName = int[].class.getName();
    String stringArrayClassName = String[].class.getName();
    System.out.println(intArrayClassName);
    System.out.println(stringArrayClassName);

    Integer[] integers = (Integer[]) Array.newInstance(Integer.class, 4);
    integers[2] = 100;

    for (Integer i : integers){
      System.out.println(i);
    }
  }
}
