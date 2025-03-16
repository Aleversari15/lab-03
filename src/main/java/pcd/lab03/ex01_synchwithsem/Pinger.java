package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

import static java.rmi.server.LogStream.log;

public class Pinger extends ActiveComponent {

	private Semaphore pingSem;
	private Semaphore pongSem;

	public Pinger(Semaphore pingSemaphore, Semaphore pongSemaphore) {
		this.pingSem = pingSemaphore;
		this.pongSem = pongSemaphore;
	}	
	
	public void run() {
		while (true){
			try {
				pingSem.acquire();
				println("ping");
			} catch (InterruptedException ex) {
				log("interrupted.");
			} finally {
				pongSem.release();
			}

		}
	}
}