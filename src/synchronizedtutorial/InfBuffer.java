package synchronizedtutorial;

public class InfBuffer {
	public static void main(String args[]) {
            Buffer buffer = new Buffer();
            Buffer2 buffer2 = new Buffer2();
            Producer prod = new Producer(buffer2);
            Consumer cons = new Consumer(buffer2);
            
            Thread producer1 = new Thread(prod);
            Thread producer2 = new Thread(prod);
            Thread producer3 = new Thread(prod);
            Thread producer4 = new Thread(prod);
            Thread producer5 = new Thread(prod);
            Thread producer6 = new Thread(prod);
            Thread consumer1 = new Thread(cons);
            Thread consumer2 = new Thread(cons);
            Thread consumer3 = new Thread(cons);
            Thread consumer4 = new Thread(cons);
            producer1.start();
            producer2.start();
            producer3.start();
            consumer1.start();
            consumer2.start();
            consumer3.start();
            consumer4.start();
	}
}

