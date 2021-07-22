class MySecondThread implements Runnable {
  @Override
  public void run(){
    try {
      long id = Thread.currentThread().getId();
      System.out.println(String.format("Thread %d is running",id));
    } catch( Exception e ){
      System.out.println("Something were terribly wrong");
    }
  }
}

class Ejemplo02Runnable {
  public static void main(String args[]) {
    int numThreads = 20;
    for (int i = 0; i < numThreads; i++) {
      Thread t = new Thread(new MySecondThread());
      t.start();
    }
  }
}
