package re_entrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    // lock keeps count of how many times it is locked, and unlock by that amount of time

    // every object has await() and notify() for java, because they are methods of Object
    // await() and signal () is for re-entrant lock, same same, but they are methods of Condition
        // you can only call these 2 AFTER you got a lock().


    // method to run
    private void increment(){
        for (int i = 0; i < 10000; i++){
            count++;
        }
    }

    // thread method
    public void firstThread() throws InterruptedException{
        lock.lock();
        cond.await(); //"wait()", unlocks lock

        try {
            increment();
        } finally {
            lock.unlock();
        }

    }


    // thread method
    public void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();
        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("Count is: " + count);

    }

}
