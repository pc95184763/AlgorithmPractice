package Practice22;

public class Counter {
  private int value ;
  public Counter(int value) {
    this.value = value ;
  }
  public void increase () {
    synchronized(this) {
      value ++ ;
    }
    System.out.println("Hello");
  }
  public synchronized void decrease () {
    value --;
  }
  public synchronized int getCount() {
    return value ;
  }
  public static void main(String [] args) {
      Counter c1 = new Counter(1) ;
      Counter c2 = new Counter(1) ;

      Thread t1 = new Thread() {
        public void run() {
          c1.increase();
        }
      };
    Thread t2 = new Thread() {
      public void run() {
        c1.increase();
      }
    };

    t1.start() ;
    t2.start() ;

    c1.increase();
    c1.increase();
    c1.decrease();
    c1.getCount();

    c2.increase();
  }


}
