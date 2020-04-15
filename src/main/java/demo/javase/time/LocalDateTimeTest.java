package demo.javase.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
  public static void main(String[] args) {


    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    LocalDate parse = LocalDate.parse("2020-04-02 22:09:20.075", dateTimeFormatter);
    LocalDateTime now = LocalDateTime.now();
    Instant instant = Instant.now();
    System.out.println(now);
    System.out.println(instant);
    System.out.println(parse);
    System.out.println(parse  );

    System.out.println(now.atZone(ZoneId.of("UTC")));
  }
}
