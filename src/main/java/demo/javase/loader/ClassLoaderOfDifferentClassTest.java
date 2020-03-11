package demo.javase.loader;

public class ClassLoaderOfDifferentClassTest {
  static {
    System.out.println("load ClassLoaderOfDifferentClassTest"); // 1
  }

  public static void main(String[] args){
    System.out.println("-----------------"); // 2
    ClassLoader loader = ClassLoaderOfClassWithMainTest.class.getClassLoader();
    System.out.println(loader); // 3 sun.misc.Launcher$AppClassLoader@18b4aac2
    System.out.println(loader.getParent()); // 4 sun.misc.Launcher$ExtClassLoader@1540e19d
    System.out.println(loader.getParent().getParent()); // 5 null
    System.out.println("*******************"); // 6
    ClassLoader anotherLoader = AnotherClass.class.getClassLoader();
    System.out.println(anotherLoader); // 7 sun.misc.Launcher$AppClassLoader@18b4aac2
    System.out.println(anotherLoader.getParent()); // 8 sun.misc.Launcher$ExtClassLoader@1540e19d
    System.out.println(anotherLoader.getParent().getParent()); // 9 null

    System.out.println(loader == anotherLoader); // 10 true
  }
}

class AnotherClass{
  static {
    System.out.println("load AnotherClass"); // doesn't run
  }
}
