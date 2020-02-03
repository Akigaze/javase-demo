package se.reflect.type.parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeDemo {
  public static void main(String[] args) {
    Field[] fields = TestEntity.class.getDeclaredFields();
    for (Field field : fields) {
      Type type = field.getGenericType();
      // Type 是 Class、ParameterizedType 等的基类
      System.out.println(field.getName() + ", " + type + ", " + type.getClass());
      System.out.println(field.getName() + ", is ParameterizedType: " + (type instanceof ParameterizedType));
    }
    System.out.println("--------- parameterizedType.getActualTypeArguments(): 泛型参数类型的列表 ---------");
    for (Field field : fields) {
      Type type = field.getGenericType();
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(field.getName() + ", TypeName: " + parameterizedType.getTypeName());
        for (Type t : actualTypeArguments) {
          System.out.println("actualTypeArgument Type: " + t.getTypeName());
        }
      }
    }

    System.out.println("--------- parameterizedType.getRawType(): 泛型对象的类型 ---------");
    for (Field field : fields) {
      Type type = field.getGenericType();
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type rawType = parameterizedType.getRawType();
        System.out.println(field.getName() + ", TypeName: " + parameterizedType.getTypeName() + ", RawType: " + rawType);
      }
    }

    System.out.println("--------- parameterizedType.getOwnerType(): 外部类的类型 ---------");
    for (Field field : fields) {
      Type type = field.getGenericType();
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type ownerType = parameterizedType.getOwnerType();
        System.out.println(field.getName() + ", TypeName: "
            + parameterizedType.getTypeName() + ", OwnerType: "
            + (ownerType));
      }
    }

    System.out.println("--------- getGenericInterfaces() ---------");
    for (Field field : fields) {
      Type[] genericInterfaces = field.getType().getGenericInterfaces();
      for (Type type : genericInterfaces) {
        System.out.println(type.getTypeName());
      }
    }

  }
}
