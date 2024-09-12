package view;

import java.util.concurrent.Semaphore;
import controller.Threadcontroller;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);
		for(int i = 1; i < 5; i++) {
			Thread t = new Threadcontroller(i, semaforo);
			t.start();
		}

	}

}
