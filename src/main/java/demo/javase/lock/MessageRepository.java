package demo.javase.lock;

public interface MessageRepository<T> {
  public T save(T entity);

  T findById(String id);
}
