package demo.javase.loader;

public class ClassLoaderExecuteStaticCodeTest {
  static {
    System.out.println("load ClassLoaderExecuteStaticCodeTest"); // 1
  }

  public static void main(String[] args) throws NoSuchFieldException {
    System.out.println("----------"); // 2
//    System.out.println(StaticClass.ID); // 3 10
//    System.out.println(StaticClass.NAME);
//    System.out.println(StaticClass.clazz);
//    StaticClass.fun();
    System.out.println("***********");
    StaticClass staticClass = new StaticClass();
    System.out.println(
      staticClass.getClass().getClassLoader() == ClassLoaderExecuteStaticCodeTest.class.getClassLoader()); // 6 true
  }
}


class StaticClass {

  // 访问静态常量属性并不会触发JVM加载所在的类
  public static final int ID = 10;
  // 访问静态属性则会触发类的加载
  public static String NAME = "no name";

  // 静态属性的初始化实际与静态代码的执行时机是一样的
  public static StaticClass clazz = new StaticClass();

  // 只有在使用静态属性(不包括静态常量)，静态方法(包括构造方法)，运行main方法，或者子类被加载 时才会触发类的加载
  static {
    System.out.println("load StaticClass"); // 4
  }

  // 执行构造方法会触发类的加载，所以构造方法其实也是静态的方法
  public StaticClass() {
    System.out.println("create StaticClass object"); // 5
  }

  // 访问静态方法会触发类的加载
  static void fun(){
    System.out.println("funny");
  }
}
