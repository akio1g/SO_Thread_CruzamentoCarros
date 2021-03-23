package controller;

import java.util.concurrent.Semaphore;

public class threadCarro extends Thread {
	private int id;
	private Semaphore semaforo;
	private String[] sentido = { "norte", "sul", "leste", "oeste" };

	@Override
	public void run() {
		try {
			semaforo.acquire();
			sleep(1000);
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public threadCarro(int id, Semaphore semaforo) {
		super();
		this.id = id;
		this.semaforo = semaforo;
	}

	private void cruzar() {
		if ((id % 2) == 0) {
			if (id-1 == sentido.length) {
				System.out.println("Carro#" + id + " indo de " + sentido[id] + " para " + sentido[id - 1]);
			} else {
				System.out.println("Carro#" + id + " indo de " + sentido[id] + " para " + sentido[id + 1]);
			}
		} else {
			System.out.println("Carro#" + id + " indo de " + sentido[id] + " para " + sentido[id - 1]);
		}
	}

}
