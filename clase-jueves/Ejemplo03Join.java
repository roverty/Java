class MiHilo implements Runnable {
  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("El hilo "+ name + " empezo a ejecutarse");
    // Calculo, operacion
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("El hilo "+ name + " termino");
  }
}

public class Ejemplo03Join {
  public static void main(String[] args){
    Thread t1 = new Thread(new MiHilo(),"Hilo-1");
    Thread t2 = new Thread(new MiHilo(),"Hilo-2");
    Thread t3 = new Thread(new MiHilo(),"Hilo-3");

    t1.start();

    try {
      t1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    t2.start();

    t3.start();
    
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Hilo principal que (main)
    System.out.println("main() terminó su ejecución");
  }
}
