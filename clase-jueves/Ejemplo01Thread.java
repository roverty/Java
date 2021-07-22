class MiPrimerHilo extends Thread {

  public MiPrimerHilo(String name) {
    super(name);
  }

  @Override
  public void run() {
    try {
      long id  = Thread.currentThread().getId();
      String name  = Thread.currentThread().getName();
      //System.out.println(String.format("El hilo con id: %d se esta ejecutando",id));
      System.out.println(String.format("El hilo con name: %s se esta ejecutando",name));
    } catch (Exception e) {
      System.out.println("Algo salió mal");
    }
  }
}

public class Ejemplo01Thread {
  public static void main(String[] args) {
    int numHilos = 10;

    for ( int i = 0; i < numHilos; i++ ){
      MiPrimerHilo hilo = new MiPrimerHilo("Hilo-"+i);
      hilo.start();
    }
  }
}
