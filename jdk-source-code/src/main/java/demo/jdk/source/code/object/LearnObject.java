package demo.jdk.source.code.object;

public class LearnObject {
  Object object;
  Object[] objects;

  static class Finalizer {
    @Override
    protected void finalize() throws Throwable {
      super.finalize();
      System.out.println("Finalizer finalize");
    }
  }

  public static void main(String[] args) {
    int i = 0;
    if (i == 0) {
      Finalizer finalizer = new Finalizer();
      System.out.println(finalizer);
      System.gc();
    }
    i++;
    System.out.println(i);
  }
}
