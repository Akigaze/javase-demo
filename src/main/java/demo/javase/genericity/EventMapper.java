package demo.javase.genericity;

import demo.javase.genericity.dto.AssetContent;

/**
 * 将一个输入的数据，经过转化处理，存入系统的一个类，
 * 定义了许多转化的规则，但是需要通过Processor将这些规则组合串联起来才能完成整个转化的工作
 * @param <I> 输入源的数据类型
 */
public abstract class EventMapper<I extends AssetContent> implements Mapper<I> {
}
