package tests;

import java.util.ArrayList;
import java.util.List;

import primecalc.PrimeCalculator;

public class GeneralTest
{
    private PrimeCalculator pCalc;
    private int maxPrime;
    private List<Integer> primes;

    public GeneralTest()
    {
        this.pCalc = new PrimeCalculator();
        this.maxPrime = maxPrime;
        this.primes = new ArrayList<>();
    }

    public void setMaxPrime(int maxPrime){
        this.maxPrime = maxPrime;
    }

    public void getPrimes() throws InterruptedException
    {
        primes = pCalc.getPrimes(maxPrime);
    }

    public String verifyRes(List<Integer> expResList){
        if (primes.equals(expResList)){
            return "PASSED";
        }
        else{
            return String.format("FAILED: Expected %s, Actual %s", expResList, primes);
        }
    }
}
