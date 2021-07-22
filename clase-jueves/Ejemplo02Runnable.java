class MiSegundoHilo implements Runnable {
  @Override
  public void run(){
    try {
      long id = Thread.currentThread().getId();
      System.out.println("Soy el hilo "+id);

    } catch(Exception e) {
      System.out.println("Algo salió mal");
    }
  }
}

public class Ejemplo02Runnable {
  public static void main(String[] args) {
    int numHilos = 10;

    for ( int i = 0; i < numHilos; i++ ){
      MiSegundoHilo hilo = new MiSegundoHilo();
      Thread t = new Thread(hilo);
      t.start();
    }
  }
}
