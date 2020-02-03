package se.reflect.type.parameterized.dto;

import se.reflect.type.parameterized.BeansUtil;
import se.reflect.type.parameterized.ReflectionUtil;

import java.lang.reflect.ParameterizedType;

public interface InputConverter<D extends InputConverter<D, E>, E> {
  default E convertTo(){
    ParameterizedType parameterizedType = ReflectionUtil.getParameterizedType(InputConverter.class, this.getClass());
    if (parameterizedType != null){
      Class<E> entityClass = (Class<E>) parameterizedType.getActualTypeArguments()[0];
      return BeansUtil.transformFrom(this, entityClass);
    }

    return null;
  }
}
