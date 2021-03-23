package view;

import java.util.concurrent.Semaphore;

import controller.threadCarro;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int id = 0;id<4;id++) {
			Thread cz = new threadCarro(id,semaforo);
			cz.start();
		}
	}

}
