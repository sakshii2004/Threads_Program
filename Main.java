package lab_9;

public class Main {
    public static void main(String[] args) {
        // making two thread objects of MyThread class
        MyThread thread1 = new MyThread("Hello", true); 
        MyThread thread2 = new MyThread("World", true);

        // running the threads
        thread1.start(); 
        thread2.start(); 

        // joining threads to wait for their completion
        try {
            thread1.join(); // main thread waiting for thread1 to finish
            thread2.join(); // main thread waiting for thread2 to finish
        } 
        
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
        
        // sleeping the current thread (main) for 5 seconds while the counter thread counts down
        try {
        	Counter c1 = new Counter(5);
        	Thread counter1 = new Thread(c1);
        	counter1.start(); // counting down till main thread wakes up again
        	System.out.println("main-thread is going to sleep for 5 seconds!!");
            Thread.sleep(5000);
        } 
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("main-thread is awake!!"); //this message will be printed once main thread resumes
        
        MyThread thread3 = new MyThread("Goodbye!", false); //creating another thread to print goodbye
        thread3.start();  // doesn't print Goodbye right away as shouldPrint is set to 'false'
        
        System.out.print("Printing goodbye in: "); // another Counter thread to count down 10 seconds
        Counter c2 = new Counter(10);
    	Thread counter2 = new Thread(c2);
    	counter2.start(); //counter starts
    	
    	try {
			counter2.join(); //main thread pauses till counter finishes counting down
		} 
    	
    	catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	thread3.setShouldPrint(true); // as soon as counting down is finished, the shouldPrint is set to true 
    	// goodbye is printed        
        
    }
}


