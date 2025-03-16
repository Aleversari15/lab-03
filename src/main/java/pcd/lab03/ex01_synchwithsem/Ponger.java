package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

import static java.rmi.server.LogStream.log;

public class Ponger extends ActiveComponent {

	private Semaphore pingSem;
	private Semaphore pongSem;

	public Ponger(Semaphore pingSemaphore, Semaphore pongSemaphore) {
		this.pingSem = pingSemaphore;
		this.pongSem = pongSemaphore;
	}

	public void run() {
		while (true){
			try {
				pongSem.acquire();
				println("pong");
			} catch (InterruptedException ex) {
				log("interrupted.");
			} finally {
				pingSem.release();
			}

		}
	}
}