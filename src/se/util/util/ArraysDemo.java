package se.util.util;

import java.util.Arrays;

public class ArraysDemo {
  public static void main(String[] args){
    Object[] nums = {3,5,7,9};
    Object[] copied = Arrays.copyOf(nums, 10);
    System.out.println(copied.length);
    for (Object i : copied){
      System.out.println(i);
    }
  }
}
