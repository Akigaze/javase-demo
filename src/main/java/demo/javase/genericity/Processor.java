package demo.javase.genericity;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 将一个输入数据转化成另一个数据
 *
 * @param <I> 输入数据的类型
 * @param <O> 目标输出的类型
 */
public interface Processor<I, O> {
  Processor<I, O> process(I input);

  <D> Processor<I, O> process(Function<I, D> function, Wrapper<D> wrapper);

  <T, D> Processor<I, O> process(Function<T, D> function, T param, Wrapper<D> wrapper);

  Processor<I, O> process(Predicate<I> predicate, Wrapper<Boolean> wrapper);

  <T> Processor<I, O> process(Predicate<T> predicate, T param, Wrapper<Boolean> wrapper);

  Processor<I, O> process(Consumer<I> consumer);

  <T> Processor<I, O> process(Consumer<T> consumer, T param);

  O result();
}
