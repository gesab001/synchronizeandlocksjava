package synchronizedtutorial;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Buffer2 {
	public static volatile LinkedList<Integer> queue = new LinkedList<Integer>();
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void write(int i) {
            rwl.writeLock().lock();
            queue.add(i);
            System.out.println(Thread.currentThread().getName() + " produced " + queue.getLast());
            rwl.writeLock().unlock();

	}

	public void read() {
                rwl.readLock().lock();
		try {
                        System.out.println(Thread.currentThread().getName() + " consumed " + queue.getFirst());
                        queue.removeFirst();
                        
		} catch(NoSuchElementException e) {
			// the buffer is empty!?
			System.out.println("buffer is empty");
		}
                rwl.readLock().unlock();
	}
}

