package Week9;

import java.math.BigInteger;

public class FactorPrimeThreadHasInterrupt extends Thread{
    private BigInteger beginGuess;
    private BigInteger result;
    private BigInteger n;
    private BigInteger step;

    public FactorPrimeThreadHasInterrupt(BigInteger n, int beginGuess, int step) {
        this.beginGuess = BigInteger.valueOf(beginGuess);
        this.n = n;
        this.step = BigInteger.valueOf(step);
    }

    public BigInteger getResult(){
        return result;
    }

    public void run(){
        System.out.println("Running thread");
        this.result = factor();
    }

    //Precondition: n is a semi-prime number.
    //Postcondition: the returned value is a prime factor of n;
    public BigInteger factor() {
//        BigInteger i = new BigInteger("2");//begin the guess from "2"
        BigInteger zero = new BigInteger("0");
        while (this.beginGuess.compareTo(this.n) < 0) {
            if (this.n.remainder(this.beginGuess).compareTo(zero) == 0) {
                this.result = beginGuess;
                FactorPrimeMultiThreadHasInterrupt.found = true;
                return this.beginGuess;
            }
            if (this.isInterrupted()){
                break;
            }
            this.beginGuess = this.beginGuess.add(this.step);
        }

        assert (false); //if this is reached, an error occurs.
        return null;
    }
}
