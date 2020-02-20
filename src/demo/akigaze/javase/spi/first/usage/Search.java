package demo.akigaze.javase.spi.first.usage;

public interface Search<K, T> {
  T search(K keyword);
}
