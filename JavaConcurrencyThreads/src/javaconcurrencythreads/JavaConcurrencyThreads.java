package javaconcurrencythreads;

/**
 *
 * @author cristiandrincu
 */
public class JavaConcurrencyThreads {

    /**
     * @param args the command line arguments
     */
    //There is no guarantee on the order of how the threads will be executed - it all depends on the scheduler of the cpu and os
    public static void main(String[] args) {
        System.out.println("Hello from the main thread.");
        Thread anotherThread = new AnotherThread(); //cannot reuse this - jvm throws exception
        anotherThread.start();
        
        //anonymous class        
        new Thread() {
            @Override
            public void run (){
                System.out.println("Hello from the anonymous class thread");
            }
        }.start();
        
        //anonymous class
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class's implementation of run");
                try {
                    anotherThread.join();
                    System.out.println("Another thread terminated, so I'm running again");
                } catch(InterruptedException e) {
                    System.out.println("I couldn't wait after all. I was inerrupted");
                }
            }
            
        });
        myRunnableThread.start();        
        
        System.out.println("Hello again from the main thread");
    }
    
}
