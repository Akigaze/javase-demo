package demo.javase.spi.first.provider;

import demo.javase.spi.first.usage.Search;

import java.util.Arrays;
import java.util.List;

public class FileSearcher implements Search<String, List<String>> {
  @Override
  public List<String> search(String keyword) {
    System.out.println("file search: hello world");
    return Arrays.asList("hello", "world");
  }
}
