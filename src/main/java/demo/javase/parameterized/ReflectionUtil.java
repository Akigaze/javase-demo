package demo.javase.parameterized;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtil {
  public static ParameterizedType getParameterizedType(){
    return null;
  }

  public static ParameterizedType getParameterizedType(Class<?> interfaceClass, Class<?> implementClass) {
    Type[] genericTypes = implementClass.getGenericInterfaces();
    for (Type genericType : genericTypes){
      if (genericType instanceof ParameterizedType){
        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        if (parameterizedType.getRawType().getTypeName().equals(interfaceClass.getTypeName())){
          return parameterizedType;
        }
      }
    }
    Class<?> superclass = implementClass.getSuperclass();
    return getParameterizedType(interfaceClass, superclass);
  }
}
