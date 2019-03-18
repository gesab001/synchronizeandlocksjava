package synchronizedtutorial;

class Consumer implements Runnable {
	Buffer buffer;
        Buffer2 buffer2;

	public Consumer(Buffer2 b) {
		buffer2 = b;
	}

	public  void run() {
               		try{
			for(int i = 1; i <= 10; i++){
			    Thread.sleep(500);
                            this.buffer2.read();
			}
		} catch (InterruptedException ie) {};
           
	}
}

