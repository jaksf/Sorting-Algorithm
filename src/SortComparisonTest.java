import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double array[] = null;
    	SortComparison sorter = new SortComparison();
    	
    	double sortedArray[] = sorter.insertionSort(array);
    	assertEquals(sortedArray, array);
    	sortedArray = sorter.selectionSort(array);
    	assertEquals(sortedArray, array);
    	sortedArray = sorter.quickSort(array);
    	assertEquals(sortedArray, array);
    	sortedArray = sorter.mergeSortIterative(array);
    	assertEquals(sortedArray, array);
    	sortedArray = sorter.mergeSortRecursive(array);
    	assertEquals(sortedArray, array);
    }
    
    
    @Test
    public void testInsertion()
    {
    }
    
    @Test
    public void testSelection()
    {
    	
    }
    
    @Test
    public void testQuick()
    {
    	
    }
    
    @Test
    public void testMergeIncursive()
    {
    	
    }
    
    @Test
    public void testMergeRecursive()
    {
    	
    }

    public void printArray(double a[])
    {
    	String array = "";
    	for(int i = 0; i < a.length; i++)
    	{
    		array += a[i];
    		if (i != a.length-1)
    		{
    			array += ", ";
    		}
    		if (i % 20 == 19)
    		{
    			array += "\n";
    		}
    	}
    	System.out.println("Array: " + array);
    }
    
    public double[] importArray(String file)
    {
    	double a[] = null;
    	return a;
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
