package demo.javase.spi.first.provider;

import demo.javase.spi.first.usage.Search;

public class DatabaseSearcher implements Search<String, String> {
  @Override
  public String search(String keyword) {
    System.out.println("database search: good morning");
    return "good morning";
  }
}
