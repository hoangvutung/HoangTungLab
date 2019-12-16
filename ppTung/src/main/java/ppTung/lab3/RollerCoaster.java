package ppTung.lab3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class RollerCoaster {
	final static Random r = new Random();
	public static ArrayList<Integer> Trips= new ArrayList<Integer>();
	public static class Controler{
		final private int M =10;
		private int counter;
		private boolean readly;
		private int personOnCar;
		
		public Controler(){
			counter=personOnCar=0;
			readly=false;
		}
		
		void checkIn() throws InterruptedException {
			  synchronized(this) {
				  while(counter == M || personOnCar>0) {
						wait();
					}
					counter++;
					readly= counter==M;
					String name = Thread.currentThread().getName();
					System.out.println(new Date() +": " + name  + "   checked in " + counter);
			  }
		}
		
		synchronized void start() throws InterruptedException  {
			  while(!readly) {
				  wait();
			  }
			notifyAll();
			String name = Thread.currentThread().getName();
			System.out.println(new Date() +": " + name  + "  is on the car " );
			personOnCar++;
			while(personOnCar <10) {
				  wait();
			}
			Trips.add(personOnCar);
		 }
		
		 synchronized void Out() throws InterruptedException {
				counter--;
				if(counter ==0) {
					readly=false;
					personOnCar=0;
					notifyAll();
				}
				String name = Thread.currentThread().getName();
				System.out.println(new Date() +": " + name  + "  finish " );
		  }
	}
	 public static class Client extends Thread {
		 Controler controler ;
		 public Client(Controler C) {
			 controler=C;
		 }
		 public void run() {
			 try {
					Thread.sleep(100 + r.nextInt(900));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					controler.checkIn();
					controler.start();
					Thread.sleep(5000); //is going
					controler.Out();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 }
	 }
}
