package synchronizedtutorial;

import java.util.Random;

class Producer implements Runnable {
	Buffer buffer;
        Buffer2 buffer2;
        Random rand = new Random();
	public Producer(Buffer2 b) {
		buffer2 = b;
	}

	public  void run() {
    		try{
			for(int i = 1; i <= 10; i++){
                            int random = rand.nextInt(50); //generates a number to add to buffer
			    Thread.sleep(500);
                            this.buffer2.write(random);
			}
		} catch (InterruptedException ie) {};
	}
}

