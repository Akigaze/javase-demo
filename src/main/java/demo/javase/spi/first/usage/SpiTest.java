package demo.javase.spi.first.usage;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 */


public class SpiTest {
  public static void main(String[] args) {
    ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);
    Iterator<Search> iterators = serviceLoader.iterator();
    while(iterators.hasNext()){
      Search search = iterators.next();
      search.search("");
    }
  }
}
