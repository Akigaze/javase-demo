package se.reflect.type.parameterized;

import se.reflect.type.parameterized.dto.InputConverter;

public class BeansUtil {

  public static void copyProperties(Object source, Object target){

  }

  public static <T> T transformFrom(Object source, Class<T> targetClass) {
    T instance = null;
    try {
      instance = targetClass.newInstance();
      BeansUtil.copyProperties(source, instance);
    } catch (Exception ignored) {

    }
    return instance;
  }
}
