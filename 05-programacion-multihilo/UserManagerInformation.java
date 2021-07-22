/**
 * @Author: rhodfra@gmail.com
 * @Date: 21/07/2021
 */
import java.util.Scanner;

class Annoyer extends Thread {
  private Thread thread;
  private String threadName;

  AnnoyingClass(String name) {
    this.threadName = name;
  }

  public void run(){
    System.out.println("Running " + threadName);
    try {
      for (int i = 10; i > 0; i--) {
        System.out.println("I am thread " + threadName + " are you typing?");
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("The thread has been interrupted ....");
    }
  }
  public void start() {
    System.out.println("Starting thread " + threadName);
    if ( thread == null ) {
      thread = new Thread(this, threadName);
      thread.start();
    }
  }
}


public class UserManagerInformation {
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    Annoyer juan = new  Annoyer("Juan");
    Annoyer karla = new Annoyer("Karla");

    juan.start();
    karla.start();

    System.out.println("Type your name:");
    String name = sc.nextLine();

    System.out.println(String.format("Your name is %s", name));

  }
}
