class Message {
  private String msg;

  public Message(String msg){
    this.msg = msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}

class Waiter implements Runnable {
  private Message msg;

  public Waiter(Message m){
    this.msg = m;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized(msg) {
      // Region de exclusion mutua
      try {
        System.out.println(name + " Se esta esperando");
        msg.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + " Se esta puede continuar");
    }
  }
}

class Notifier implements Runnable {
  private Message msg;

  public Notifier(Message m){
    this.msg = m;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println(name + " se inicio");

    try {
      synchronized(msg) {
        // Region de exclusion mutua
        //////////////////
        Thread.sleep(3000);
        msg.setMsg(name + "Este es otro mensaje");
        //////////////////
        //msg.notify();
        msg.notifyAll();
        System.out.println(name + " Se esta puede continuar");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class Ejemplo04Notifications {
  public static void main(String[] args) {
    Message msg = new Message("Cadena de inicio");

    Waiter waiter = new Waiter(msg);
    Thread t1 = new Thread(waiter,"waiter");
    t1.start();

    Waiter waiter1 = new Waiter(msg);
    Thread t2 = new Thread(waiter1,"waiter1");
    t2.start();

    Notifier notifier = new Notifier(msg);
    Thread t3 = new Thread(notifier,"notifier");
    t3.start();

    System.out.println("Los 3 hilos se han inicio");
  }
}
