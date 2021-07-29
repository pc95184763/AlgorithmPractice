package Practice22;

public class MyThread {
  public void run() {

  }
  public void start() {
    run() ;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread() {
      public void run() {
        System.out.println("Hello1") ;
      }

    } ;
    t.start();
    Thread.sleep(100);
    Thread.yield();
    System.out.println("Hello2");
    t.join();
    System.out.println("Hello3") ;
  }
}
