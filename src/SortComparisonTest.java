import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

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
    	SortComparison sorter = new SortComparison();
    	double[] ordered = {};
    	double[] orderedInsertion = sorter.insertionSort(ordered);
    	double[] orderedSelection = sorter.selectionSort(ordered);
    	double[] orderedQuick = sorter.quickSort(ordered);
    	double[] orderedMergeSortIterative = sorter.mergeSortIterative(ordered);
    	double[] orderedMergeSortRecursive = sorter.mergeSortRecursive(ordered);
    	assertEquals(sorter.isSorted(orderedInsertion), true);
    	assertEquals(sorter.isSorted(orderedSelection), true);
    	assertEquals(sorter.isSorted(orderedQuick), true);
    	assertEquals(sorter.isSorted(orderedMergeSortIterative), true);
    	assertEquals(sorter.isSorted(orderedMergeSortRecursive), true);
    }
    
    @Test
    public void testOrdered()
    {
    	SortComparison sorter = new SortComparison();
    	double[] ordered = {1,2,3,4,5};
    	double[] orderedInsertion = sorter.insertionSort(ordered);
    	double[] orderedSelection = sorter.selectionSort(ordered);
    	double[] orderedQuick = sorter.quickSort(ordered);
    	double[] orderedMergeSortIterative = sorter.mergeSortIterative(ordered);
    	double[] orderedMergeSortRecursive = sorter.mergeSortRecursive(ordered);
    	assertEquals(sorter.isSorted(orderedInsertion), true);
    	assertEquals(sorter.isSorted(orderedSelection), true);
    	assertEquals(sorter.isSorted(orderedQuick), true);
    	assertEquals(sorter.isSorted(orderedMergeSortIterative), true);
    	assertEquals(sorter.isSorted(orderedMergeSortRecursive), true);
    }
    
    @Test
    public void testReverseOrdered()
    {
    	SortComparison sorter = new SortComparison();
    	double[] ordered = {5,4,3,2,1};
    	double[] orderedInsertion = sorter.insertionSort(ordered);
    	double[] orderedSelection = sorter.selectionSort(ordered);
    	double[] orderedQuick = sorter.quickSort(ordered);
    	double[] orderedMergeSortIterative = sorter.mergeSortIterative(ordered);
    	double[] orderedMergeSortRecursive = sorter.mergeSortRecursive(ordered);
    	assertEquals(sorter.isSorted(orderedInsertion), true);
    	assertEquals(sorter.isSorted(orderedSelection), true);
    	assertEquals(sorter.isSorted(orderedQuick), true);
    	assertEquals(sorter.isSorted(orderedMergeSortIterative), true);
    	assertEquals(sorter.isSorted(orderedMergeSortRecursive), true);
    }
    
    @Test
    public void testUnsorted()
    {
    	SortComparison sorter = new SortComparison();
    	double[] a = {2,2,1,4};
    	assertEquals(sorter.isSorted(a), false);
    }
    
    @Test
    public void testSorted()
    {
    	SortComparison sorter = new SortComparison();
    	double[] a = {1,2,3,5};
    	assertEquals(sorter.isSorted(a), true);
    }
    
    
    @Test
    public void testInsertion()
    {
    	SortComparison sorter = new SortComparison();
    	double[] unordered = {5,3,2,8,9,4,0,0,3};
    	double[] orderedInsertion = sorter.insertionSort(unordered);
    	assertEquals(sorter.isSorted(orderedInsertion), true);
    }
    
    @Test
    public void testSelection()
    {
    	SortComparison sorter = new SortComparison();
    	double[] unordered = {5,3,2,8,9,4,0,0,3};
    	double[] orderedSelection = sorter.selectionSort(unordered);
    	assertEquals(sorter.isSorted(orderedSelection), true);
    }
    
    @Test
    public void testQuick()
    {
    	SortComparison sorter = new SortComparison();
    	double[] unordered = {5,3,2,8,9,4,0,0,3};
    	double[] orderedQuick = sorter.quickSort(unordered);
    	assertEquals(sorter.isSorted(orderedQuick), true);
    }
    
    @Test
    public void testMergeIncursive()
    {
    	SortComparison sorter = new SortComparison();
    	double[] unordered = {5,3,2,8,9,4,0,0,3};
    	double[] orderedMergeIterative = sorter.mergeSortIterative(unordered);
    	assertEquals(sorter.isSorted(orderedMergeIterative), true);
    }
    
    @Test
    public void testMergeRecursive()
    {
    	SortComparison sorter = new SortComparison();
    	double[] unordered = {5,3,2,8,9,4,0,0,3};
    	double[] orderedMergeRecursive = sorter.mergeSortRecursive(unordered);
    	assertEquals(sorter.isSorted(orderedMergeRecursive), true);
    }
//    @Test
//    public void testImportedArraySort()
//    {
//    	SortComparison sorter = new SortComparison();
//    	double[] ordered = {};
//		ordered = importArray("numbers100000.txt", 100000);
//    	double[] orderedInsertion = sorter.insertionSort(ordered);
//    	double[] orderedSelection = sorter.selectionSort(ordered);
//    	double[] orderedQuick = sorter.quickSort(ordered);
//    	double[] orderedMergeSortIterative = sorter.mergeSortIterative(ordered);
//    	double[] orderedMergeSortRecursive = sorter.mergeSortRecursive(ordered);
//    	assertEquals(sorter.isSorted(orderedInsertion), true);
//    	assertEquals(sorter.isSorted(orderedSelection), true);
//    	assertEquals(sorter.isSorted(orderedQuick), true);
//    	assertEquals(sorter.isSorted(orderedMergeSortIterative), true);
//    	assertEquals(sorter.isSorted(orderedMergeSortRecursive), true);
//    }
    
//    public void printArray(double a[])
//    {
//    	String array = "";
//    	for(int i = 0; i < a.length; i++)
//    	{
//    		array += a[i];
//    		if (i != a.length-1)
//    		{
//    			array += ", ";
//    		}
//    		if (i % 20 == 19)
//    		{
//    			array += "\n";
//    		}
//    	}
//    	System.out.println("Array: " + array);
//    }
    
//    public double[] importArray(String fileLocation, int size)
//    {
//    	File file = new File(fileLocation);
//    	Scanner scanner = null;
//		try {
//			scanner = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	double[] array = new double[size];
//    	int i =0;
//    	while(scanner.hasNextDouble())
//    	{
//    		   array[i++] = scanner.nextInt();
//    	}
//    	return array;
//    }

    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
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
