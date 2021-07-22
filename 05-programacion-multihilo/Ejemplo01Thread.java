class MyFirstThread extends Thread {
  public void run() {
    try {
      long id = Thread.currentThread().getId();
      System.out.println(String.format("Thread %d is running",id));
    } catch(Exception e) {
      System.out.println("Something went wrong");
    }
  }
}

public class Ejemplo01Thread {
  public static void main(String[] args) {
    int numThreads = 10;

    for (int i = 0; i < numThreads; i++) {
      MyFirstThread t = new MyFirstThread();
      t.start();
    }
  }
}
