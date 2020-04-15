package demo.javase.genericity;

import demo.javase.genericity.dto.AssetContent;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 将一个输入的数据，经过转化处理，存入系统的一个类，
 * 定义了许多转化的规则，但是需要通过Processor将这些规则组合串联起来才能完成整个转化的工作
 *
 * @param <I> 输入源的数据类型
 */
public abstract class EventProcessor<I extends AssetContent, O> implements Processor<I, O> {
  private I input;

  private O result;

  public I getInput() {
    return input;
  }

  public void setInput(I input) {
    this.input = input;
  }

  public O result() {
    return result;
  }

  public void setResult(O result) {
    this.result = result;
  }

  @Override
  public <D> EventProcessor<I, O> process(Function<I, D> function, Wrapper<D> wrapper) {
    wrapper.set(function.apply(this.getInput()));
    return this;
  }

  @Override
  public EventProcessor<I, O> process(Predicate<I> predicate, Wrapper<Boolean> wrapper) {
    wrapper.set(predicate.test(this.getInput()));
    return this;
  }

  @Override
  public <T, D> Processor<I, O> process(Function<T, D> function, T param, Wrapper<D> wrapper) {
    wrapper.set(function.apply(param));
    return this;
  }

  @Override
  public <T> Processor<I, O> process(Predicate<T> predicate, T param, Wrapper<Boolean> wrapper) {
    wrapper.set(predicate.test(param));
    return this;
  }

  @Override
  public EventProcessor<I, O> process(Consumer<I> consumer) {
    consumer.accept(this.getInput());
    return this;
  }

  @Override
  public <T> EventProcessor<I, O> process(Consumer<T> consumer, T param) {
    consumer.accept(param);
    return this;
  }
}
