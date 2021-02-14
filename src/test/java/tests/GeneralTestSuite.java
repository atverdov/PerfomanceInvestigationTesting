package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralTestSuite
{
    public static void main( String[] args )
    {
        GeneralTest test = new GeneralTest();
        Map<Integer, List<Integer>> testMap = new HashMap<>();
        testMap.put(0, new ArrayList<>());
        testMap.put(1, new ArrayList<>());
        testMap.put(10, new ArrayList<>(Arrays.asList(2,3,5,7)));
        testMap.put(30, new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29)));

        String testName;
        for(Integer key: testMap.keySet()){
            testName = String.format("Test maxPrime=%s ", key);
            test.setMaxPrime(key);
            try {
                System.out.println(testName+" is started");
                test.getPrimes();
            } catch ( InterruptedException e ) {
                System.out.println(testName+" is Failed with the following issue: "+e);
            }
            System.out.println(testName + test.verifyRes(testMap.get(key)));
        }
    }
}
