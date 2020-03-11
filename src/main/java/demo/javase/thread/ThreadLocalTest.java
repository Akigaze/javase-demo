package demo.javase.thread;

public class ThreadLocalTest {
  private static ThreadLocal<Integer> times = new ThreadLocal<>();

  static {
    times.set(0);
  }

  public static void increaseTimes(int increment){
    times.set((times.get() == null ? 0 : times.get()) + increment);
  }

  public static int getTimes(){
    return times.get();
  }

  public static void main(String[] args) {
    TestThread t1 = new TestThread("test-1");
    TestThread t2 = new TestThread("test-2");

    t1.start();
    t2.start();
  }
}


class TestThread extends Thread{
  public TestThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++){
      ThreadLocalTest.increaseTimes(i);
      System.out.println(this.getName() + " : " + ThreadLocalTest.getTimes());
    }
  }
}