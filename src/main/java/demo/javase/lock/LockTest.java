package demo.javase.lock;


import java.util.LinkedHashMap;
import java.util.Map;

public class LockTest {

  static class TestThread extends Thread{
    private Worker worker;

    public TestThread(String name, Worker worker) {
      super(name);
      this.worker = worker;
    }

    public TestThread(Worker worker) {
      this.worker = worker;
    }

    @Override
    public void run() {
      for (int i = 0; i< 1000; i ++){
        worker.work(i);
      }
    }
  }

  static class Worker {
    private static final Map<String, Integer> cache = new LinkedHashMap<>();

    private String goods;

    public Worker(String goods) {
      this.goods = goods;
    }

    public String getGoods() {
      return goods;
    }

    public void work(Integer value){

      System.out.println(goods + " before: " + cache.get(goods));

      synchronized (cache){
        cache.put(goods, value);
        try {
          System.out.println(goods + " sleeping");
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println(goods + " after: " + cache.get(goods));
    }

  }

  public static void main(String[] args) {
    Worker worker1 = new Worker("hello");
    Worker worker2 = new Worker("fish");
    Worker worker3 = new Worker("beef");
    Worker worker4 = new Worker("toufu");

    TestThread t1 = new TestThread("t1", worker1);
    TestThread t2 = new TestThread("t2", worker2);
    TestThread t3 = new TestThread("t3", worker3);
    TestThread t4 = new TestThread("t4", worker4);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
