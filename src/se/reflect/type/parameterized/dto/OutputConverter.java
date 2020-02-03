package se.reflect.type.parameterized.dto;

import se.reflect.type.parameterized.BeansUtil;

public interface OutputConverter<D extends OutputConverter<D, E>, E> {
  default D convertFrom(E entity) {
    BeansUtil.copyProperties(entity, this);
    return (D) this;
  }
}
