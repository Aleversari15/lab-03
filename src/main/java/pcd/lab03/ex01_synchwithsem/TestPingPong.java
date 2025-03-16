package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore pingSemaphore = new Semaphore(1);
		Semaphore pongSemaphore = new Semaphore(0);
		new Pinger(pingSemaphore,pongSemaphore).start();
		new Ponger(pingSemaphore,pongSemaphore).start();
	}

}
