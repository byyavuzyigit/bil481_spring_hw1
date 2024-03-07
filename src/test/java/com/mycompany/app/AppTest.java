package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;


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

    // checking if the method's working when the two arraylist inputs are valid.
    public void testBothListsAreValid(){
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(4,3,2,1));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        String text1 = "ab";
        String text2 = "cd";
        assertEquals(App.concatText(list1, list2, text1, text2), "ababababcdabababcdcdababcdcdcdab");
    }
    // checking if the method's working when one of the arraylist input is null.
    public void testOneListNull(){
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        String text1 = "ab";
        String text2 = "cd";
        assertEquals(App.concatText(null, list2, text1, text2), "cdcdcdcdcdcd");
    }
    // checking if the method's working when both of the arraylist inputs are null.
    public void testTwoListNull(){
        String text1 = "ab";
        String text2 = "cd";
        assertEquals(App.concatText(null, null, text1, text2), "");
    }
    // checking if the method's working when one of the string is null.
    public void testOneStringNull(){
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(4,3,2,1));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        String text2 = "cd";
        assertEquals(App.concatText(list1, list2, null, text2), "cdcdcdcdcdcd");
    }
    // checking if the method's working when one of the list contains negative element.
    public void testListContainsNegativeElement(){
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(4,3,2,1,-5,0,-12));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        String text1 = "ab";
        String text2 = "cd";
        assertEquals(App.concatText(list1, list2, text1, text2), "ababababcdabababcdcdababcdcdcdab");
    }

}
