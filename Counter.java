package lab_9;

public class Counter implements Runnable {
	
	// value of counter
	int counter;
	
	// constructor 
	public Counter(int counter) {
		this.counter = counter;
	}

	@Override
	public void run() {	
		for (int i = counter; i>0; i--) {
			System.out.println(i);
			try {
	            Thread.sleep(1000); // waiit for 1 second after every count
	        } 
			
			catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}

}
