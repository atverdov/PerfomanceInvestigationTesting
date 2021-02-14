package tests;

import java.time.Duration;
import java.time.Instant;

public class LoadTestSuite
{
    public static void main( String[] args )
    {
        GeneralTest test = new GeneralTest();
        String testName;
        int maxFailedTestsNum = 1;
        int failedTestsNum = 0;
        int step = 100_000;
        int maxPrime = 100_000;
        int limitMaxPrime = 700_000;

        while ( true ){
            Instant start = Instant.now();
            testName = String.format("Test maxPrime=%s ", maxPrime);
            test.setMaxPrime(maxPrime);
            try {
                System.out.println(testName+" is started");
                test.setMaxPrime(maxPrime);
                test.getPrimes();
                System.out.println(testName+" is PASSED");
            } catch ( Exception|Error e ) {
                System.out.println(e.getStackTrace());
                System.out.println(testName+" is FAILED with the following issue: "+e);
                failedTestsNum+=1;
                if (failedTestsNum==maxFailedTestsNum){
                    System.out.println("LOAD TESTING WILL BE STOPPED DUE TO A BIG NUMBER OF ERRORS");
                    break;
                }
            }
            finally {
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);
                System.out.println("Test duration: "+ timeElapsed.toMillis()/1000 +" seconds");
                if (maxPrime>=limitMaxPrime||failedTestsNum>=maxFailedTestsNum){
                    break;
                }
                maxPrime+=step;
            }

        }
    }
}
