package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void test1() {
	int[] arr1={3,2,7,9,5,32,53};
        int[] arr2={5,32,12,66,3,55,9,4};
        assertTrue(new App().aradadir(arr1,arr2,4,10));

        
    }

   
    public void test2() {

	int[] arr1={3,2,7,9,5,32,53};
        int[] arr2={5,32,12,66,3,55,9,4};
        new App().aradadir(arr1,arr2,55,66);
        assertTrue(new App().aradadir(arr1,arr2,55,66));

    }

 
    public void test3() {
	    int[] arr1={3,2,7,9,5,32,53};
        int[] arr2={5,32,12,66,3,55,9,4};
        assertFalse(new App().aradadir(arr1,arr2,1,1));


    }

    
    public void test4() {

	int[] arr1={3,2,7,9,5,32,53};
        int[] arr2={5,32,12,66,3,55,9,4};
        assertTrue(new App().aradadir(arr1,arr2,11,13));

    }

    
    public void test5() {
    
	int[] arr1={3,2,7,9,5,32,53};
        int[] arr2={5,32,12,66,3,55,9,4};
        assertTrue(new App().aradadir(arr1,arr2,1111,3333));


    }


}
