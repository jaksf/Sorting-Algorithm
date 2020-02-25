//		|Insert|Selection|MRecursive|MIterative|Quick|
//10 Random	0.049299 | 0.0206 | 0.0398 | 0.2343 | 0.023801
//100 Random	0.2179 | 0.3285 | 0.231801 | 0.155299 | 0.094899
//1000 Random	11.3738 | 15.5845 | 2.1548 | 1.591599 | 1.3001
//10000 Random	171.2345 | 41.6507 | 1.4855 | 2.9235 | 1.597199
//10000 Nearly Ordered	1.9883 | 42.0464 | 0.7369 | 1.1503 | 0.9222
//10000 Reversed	26.9528 | 45.691999 | 0.5498 | 0.9776 | 65.0101
//10000 Sorted	0.0546 | 67.452101 | 0.9148 | 1.4161 | 131.4399


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
    public void testMergeIterative()
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
    
    @Test
    public void testPrintArray()
    {
    	double array[] = {0,2,3};
    	printArray(array);
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
    
    public static void printArray(double a[])
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
    
    public static double[] importArray(String fileLocation, int size)
    {
    	File file = new File(fileLocation);
    	double result[] = new double[size];
    	Scanner scan;
    	try {
            scan = new Scanner(file);

            int i =0;
            while(scan.hasNextDouble() && i < size)
            {
                result[i] = scan.nextDouble();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
		return result;
    	
    }

    public static double sortDuration(String sortname, double array[])
    {
    	SortComparison sort = new SortComparison();
    	double startTime = System.nanoTime();
    	switch(sortname)
    	{
    	case "insertionSort":
    		sort.insertionSort(array);
    		break;
    	case "quickSort":
    		sort.quickSort(array);
    		break;
    	case "selectionSort":
    		sort.selectionSort(array);
    		break;
    	case "mergeIterativeSort":
    		sort.mergeSortIterative(array);
    		break;
    	case "mergeRecursiveSort":
    		sort.mergeSortRecursive(array);
    		break;
    		
    	default:
    		return -1;
    	}
    	double endTime = System.nanoTime();
    	double duration = (endTime - startTime) / 1000000 ;
    	return duration;
    }
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
        double array10[];
        array10 = importArray("numbers10000.txt", 10);
        double array100[];
        array100 = importArray("numbers10000.txt", 100);
        double array1000[];
        array1000 = importArray("numbers10000.txt", 1000);
        double array10000[];
        array10000 = importArray("numbers10000.txt", 10000);
        double array10000FewUnique[];
        array10000FewUnique = importArray("numbers10000Duplicates.txt", 10000);
        double arrayNearlyOrdered[];
        arrayNearlyOrdered = importArray("resNearlyOrdered10000.txt", 10000);
        double arrayReversed[];
        arrayReversed = importArray("numbersReverse10000.txt", 10000);
        double arraySorted[];
        arraySorted = importArray("numbersSorted10000.txt", 10000);
        
        System.out.println("		|Insert|Selection|MRecursive|MIterative|Quick|");
        System.out.println("10 Random	"+ sortDuration("insertionSort", array10) 
        + " | "+ sortDuration("selectionSort", array10) 
        + " | "+ sortDuration("mergeRecursiveSort", array10) 
        +" | "+ sortDuration("mergeIterativeSort", array10) 
        +" | "+ sortDuration("quickSort", array10));
        
        System.out.println("100 Random	"+ sortDuration("insertionSort", array100) 
        + " | "+ sortDuration("selectionSort", array100) 
        + " | "+ sortDuration("mergeRecursiveSort", array100) 
        +" | "+ sortDuration("mergeIterativeSort", array100) 
        +" | "+ sortDuration("quickSort", array100));
        
        System.out.println("1000 Random	"+ sortDuration("insertionSort", array1000) 
        + " | "+ sortDuration("selectionSort", array1000) 
        + " | "+ sortDuration("mergeRecursiveSort", array1000) 
        +" | "+ sortDuration("mergeIterativeSort", array1000) 
        +" | "+ sortDuration("quickSort", array1000));
        
        System.out.println("10000 Random	"+ sortDuration("insertionSort", array10000) 
        + " | "+ sortDuration("selectionSort", array10000) 
        + " | "+ sortDuration("mergeRecursiveSort", array10000) 
        +" | "+ sortDuration("mergeIterativeSort", array10000) 
        +" | "+ sortDuration("quickSort", array10000));
        
        System.out.println("10000 Nearly Ordered	"+ sortDuration("insertionSort", arrayNearlyOrdered) 
        + " | "+ sortDuration("selectionSort", arrayNearlyOrdered) 
        + " | "+ sortDuration("mergeRecursiveSort", arrayNearlyOrdered) 
        +" | "+ sortDuration("mergeIterativeSort", arrayNearlyOrdered) 
        +" | "+ sortDuration("quickSort", arrayNearlyOrdered));
        
        System.out.println("10000 Reversed	"+ sortDuration("insertionSort", arrayReversed) 
        + " | "+ sortDuration("selectionSort", arrayReversed) 
        + " | "+ sortDuration("mergeRecursiveSort", arrayReversed) 
        +" | "+ sortDuration("mergeIterativeSort", arrayReversed) 
        +" | "+ sortDuration("quickSort", arrayReversed));
        
        System.out.println("10000 Sorted	"+ sortDuration("insertionSort", arraySorted) 
        + " | "+ sortDuration("selectionSort", arraySorted) 
        + " | "+ sortDuration("mergeRecursiveSort", arraySorted) 
        +" | "+ sortDuration("mergeIterativeSort", arraySorted) 
        +" | "+ sortDuration("quickSort", arraySorted));
    }

}
