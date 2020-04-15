package demo.javase.genericity;

import java.util.Optional;

public class Wrapper<T> {
  private Optional<T> value;

  public void set(T value) {
    this.value = Optional.of(value);
  }

  public T get(){
    if (value == null || !value.isPresent()){
      return null;
    }
    return value.get();
  }
}
