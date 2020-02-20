package demo.akigaze.javase.loader;

//同一个class使用不同类加载器加载得到的Class对象并不是同一个，不能相互转换

public class ClassLoaderOfClassWithMainTest {
  static {
    System.out.println("load ClassLoaderOfClassWithMainTest"); // 1
  }
  public static void main(String[] args){
    System.out.println("-------------"); // 2
    ClassLoader loader = ClassLoaderOfClassWithMainTest.class.getClassLoader();
    System.out.println(loader); // 3 sun.misc.Launcher$AppClassLoader@18b4aac2
    System.out.println(loader.getParent()); // 4 sun.misc.Launcher$ExtClassLoader@1540e19d
    System.out.println(loader.getParent().getParent()); // 5 null
  }
}
