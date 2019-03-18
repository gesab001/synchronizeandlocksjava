package synchronizedtutorial;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class Buffer {
	public static volatile LinkedList<Integer> queue = new LinkedList<Integer>();
	
	public synchronized void write(int i) {
            queue.add(i);
            System.out.println(Thread.currentThread().getName() + " produced " + queue.getLast());

	}

	public synchronized int read() {
		try {
                        System.out.println(Thread.currentThread().getName() + " consumed " + queue.getFirst());
			return queue.removeFirst();
		} catch(NoSuchElementException e) {
			// the buffer is empty!?
			return -1;
		}
	}
}

