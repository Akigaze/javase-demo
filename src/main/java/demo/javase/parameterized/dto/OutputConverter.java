package demo.javase.parameterized.dto;

import demo.javase.parameterized.BeansUtil;

public interface OutputConverter<D extends OutputConverter<D, E>, E> {
  default D convertFrom(E entity) {
    BeansUtil.copyProperties(entity, this);
    return (D) this;
  }
}
