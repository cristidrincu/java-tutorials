package producerconsumerthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import static producerconsumerthreads.ProducerConsumer.EOF;

/**
 *
 * @author cristiandrincu
 */
public class ProducerConsumer {
    public static final String EOF = "EOF";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<String> buffer = new ArrayList<>();
       ReentrantLock bufferLock = new ReentrantLock();
       ExecutorService executorService = Executors.newFixedThreadPool(3); //only 3 threads allowed to coexist - overkill to use ExecutorService for an application that uses only 3 threads - comes in handy for apps with hundreds of threads
       
       MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
       MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
       MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
//       Instead of calling the below 3 lines, we can use the executorService to manage the start of the threads, as well as to shutdown the threads
//       new Thread(producer).start();
//       new Thread(consumer1).start();
//       new Thread(consumer2).start();

      executorService.execute(producer);
      executorService.execute(consumer1);
      executorService.execute(consumer2);      
      
      //The Callable has to wait until the 3 threads, producer, consumer1 and consumer2 finish their tasks - so it will execute after the 3 threads - adding 4 to newFixedThreadPool(4) will fix this       
      Future<String> future = executorService.submit(new Callable<String>() {
           @Override
           public String call() throws Exception {
               System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class");
               return "This is the callable result";
           }      
      });
      
      try {
          System.out.println(future.get());
      } catch (ExecutionException e) {
          System.out.println("Something went wrong!");
      } catch (InterruptedException e) {
          System.out.println("Thread running the task was interrupted");
      }
      
      executorService.shutdown();
    }        
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        
        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num); 
                // ArrayList is not thread safe, so we need to lock the adding of a number, so no other thread can access/interfere the array list while we do so - we are using ArrayList in the main method - List<String> buffer = new ArrayList<>();
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally { //this block of code will be executed no matter what - so we can guarantee that we are releasing the lock, so other threads can get a hold of the lock and we do not block indefinetly
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        
        System.out.println(color + "Adding EOF and exiting...");
        //ArrayList is not thread safe, so we need to lock the adding of an element, so no other thread can access/interfere the array list while we do so - we are using ArrayList in the main method - List<String> buffer = new ArrayList<>();        
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
    
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while(true) {
            bufferLock.lock();
            try {
                //ArrayList is not thread safe, so we need to lock the isEmpty(), get(indexNumber) and remove(indexNumber) methods, so no other thread can access/interfere the array list while we do so - we are using ArrayList in the main method - List<String> buffer = new ArrayList<>();
                if (buffer.isEmpty()) {                    
                    continue;
                }
                if(buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");                    
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally { //this block of code will be executed no matter what - so we can guarantee that we are releasing the lock, so other threads can get a hold of the lock and we do not block indefinetly
                bufferLock.unlock();
            }
        }        
    }
}
