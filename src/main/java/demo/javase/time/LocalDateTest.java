package demo.javase.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();

    LocalDate parse = LocalDate.parse("2020-04-02 01:09:20.075", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    LocalDateTime localDateTime = parse.atStartOfDay();
    System.out.println(now.toEpochDay());
    System.out.println(localDateTime);
    System.out.println(parse);
  }
}
