package Week9;

import java.math.BigInteger;

public class FactorPrimeMultiThreadNoInterrupt {
    public static void main(String[] args) throws InterruptedException {
        int numOfThreads = 10;
        BigInteger[] results = new BigInteger[numOfThreads];
        BigInteger numberToBeFactored = new BigInteger("123123");

        // create array of threads
        FactorPrimeThreadNoInterrupt[] arrayOfThreads = new FactorPrimeThreadNoInterrupt[numOfThreads];

        // start threads
        for (int i = 0; i < numOfThreads; i++){
            arrayOfThreads[i] = new FactorPrimeThreadNoInterrupt(numberToBeFactored, i + 2, numOfThreads);
            arrayOfThreads[i].start();
        }

        // wait for threads to finish
        for (int i = 0; i < numOfThreads; i++){
            arrayOfThreads[i].join();
            results[i] = arrayOfThreads[i].getResult();
            // print out results
            System.out.println(results[i]);

        }



    }

}
