package demo.javase.datetime;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class InstantDemo {
  public static void now(){
    Instant now = Instant.now(); // Instant 默认使用的是UTC时区
    System.out.println(now);
    System.out.println(now.getEpochSecond()); // 总秒数
    System.out.println(now.toEpochMilli()); //总毫秒数
    System.out.println(now.getNano()); //纳秒 ??
  }

  public static void of(){
    Instant now = Instant.now();
    System.out.println(now);
    Instant secondInstant = Instant.ofEpochSecond(now.getEpochSecond()); // 会丢失毫秒数
    System.out.println(secondInstant);
    System.out.println(now.getEpochSecond() == secondInstant.getEpochSecond());
    System.out.println(now.toEpochMilli() == secondInstant.toEpochMilli());

    Instant milliInstant = Instant.ofEpochMilli(now.toEpochMilli()); // 保留毫秒数
    System.out.println(milliInstant);
    System.out.println(now.getEpochSecond() == milliInstant.getEpochSecond());
    System.out.println(now.toEpochMilli() == milliInstant.toEpochMilli());
  }

  public static void plus(){
    Instant now = Instant.now();
    long secondsToAdd = TimeUnit.HOURS.toSeconds(1);
    System.out.println("seconds to add: " + secondsToAdd);
    Instant plusSecondsInstant = now.plusSeconds(secondsToAdd);
    System.out.println(now);
    System.out.println(plusSecondsInstant);

    System.out.println(now.getEpochSecond());
    System.out.println(plusSecondsInstant.getEpochSecond());
  }


  public static void main(String[] args) {
    now();
    System.out.println("--------------");
    of();
    System.out.println("--------------");
    plus();
  }
}
