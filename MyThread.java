package lab_9;

class MyThread extends Thread {
    private String message;
    private boolean shouldPrint;
    
    // constructor
    public MyThread(String message, boolean shouldPrint) {
        this.message = message;
        this.shouldPrint = shouldPrint;
    }
    
    // method to set the message 
    public synchronized void setMessage(String message) {
        this.message = message;
    }
    
    // method to get the message 
    public synchronized String getMessage() {
        return this.message;
    }

    // the run method will first check the shouldPrint attribute and if it's true, it'll print the message
    @Override
    public synchronized void run() {
        try {
            // thread must wait until shouldPrint becomes true
            while (!shouldPrint) {
                wait();
            }
            // when shouldPrint becomes true, print the message
            System.out.println(getMessage());
        } 
        
        catch (InterruptedException e) {
        	System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
    
    // method to set the value of shouldPrint
    public synchronized void setShouldPrint(boolean shouldPrint) {
        this.shouldPrint = shouldPrint;
        if (shouldPrint) {
            notify(); // if shouldPrint is true, notify all the waiting threads
        }
    }
}
