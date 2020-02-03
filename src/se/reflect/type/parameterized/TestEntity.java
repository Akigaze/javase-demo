package se.reflect.type.parameterized;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestEntity {
  private List names; // getGenericType -> Class
  private List<String> cities; // getGenericType -> ParameterizedTypeImpl
  private Response response; // getGenericType -> Class
  private Response<Integer> resp; // getGenericType -> ParameterizedTypeImpl
  private Map map; // getGenericType -> Class
  private Map<String, Integer> scores; // getGenericType -> ParameterizedTypeImpl
  private Map.Entry<Date, Class> entry; // getGenericType -> ParameterizedTypeImpl
}
