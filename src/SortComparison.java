import java.util.Arrays;


//|Insert|Selection|MRecursive|MIterative|Quick|
//10 Random	0.049299 | 0.0206 | 0.0398 | 0.2343 | 0.023801
//100 Random	0.2179 | 0.3285 | 0.231801 | 0.155299 | 0.094899
//1000 Random	11.3738 | 15.5845 | 2.1548 | 1.591599 | 1.3001
//10000 Random	171.2345 | 41.6507 | 1.4855 | 2.9235 | 1.597199
//10000 Nearly Ordered	1.9883 | 42.0464 | 0.7369 | 1.1503 | 0.9222
//10000 Reversed	26.9528 | 45.691999 | 0.5498 | 0.9776 | 65.0101
//10000 Sorted	0.0546 | 67.452101 | 0.9148 | 1.4161 | 131.4399

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author	Finn Jaksland
 *  @version HT 2020
 */

 class SortComparison{

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	double [] array = a.clone();
        for(int i = 1; i < a.length; i++)
       {
        double key = array[i];
        int j = i - 1;
        
        while(j >= 0 && array[j] > key)
       {
        	array[j+1] = array[j];
        	j = j -1;
        }
        array[j+1] = key;
        }
        return array;
    }
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	double [] array = a.clone();
    	int n = array.length; 
        for (int i = 0; i < n-1; i++) 
       {
            int min = i; 
            for (int j = i+1; j < n; j++)
           {
            	if (array[j] < array[min])
            	{
            		min = j;
            	}
            }
            double temp = array[min]; 
            array[min] = array[i]; 
            array[i] = temp; 
        }
    	return array;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[])
   {
    	double [] array = a.clone();
    	quickSorter(array, 0, array.length - 1);
    	return array;
    }
    
    private static void quickSorter(double a[], int low, int high)
   {
    	if (low < high) 
       {
            int pi = quickSortPartition(a, low, high); 
            quickSorter(a, low, pi-1); 
            quickSorter(a, pi+1, high); 
        }
    }
    
    private static int quickSortPartition(double a[], int low, int high)
   {
    	double pivot = a[high];  
        int i = (low-1);
        for (int j = low; j < high; j++) 
       {
            if (a[j] < pivot) 
           {
                i++; 
                double temp1 = a[i]; 
                a[i] = a[j]; 
                a[j] = temp1; 
            }
        }
        double temp2 = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp2; 
  
        return i+1; 
    }
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[])
    {
    	double [] array = a.clone();
    	int low = 0;
		int high = array.length - 1;

		double[] temp = Arrays.copyOf(array, array.length);
		for (int m = 1; m <= high - low; m = 2*m)
		{
			for (int i = low; i < high; i += 2*m)
			{
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);
				mergeSortIterativeMerge(array, temp, from, mid, to);
			}
		}
    	return array;
    }
    
    static private void mergeSortIterativeMerge(double[] a, double[] temp, int from, int mid, int to)
    {
    	int k = from, i = from, j = mid + 1;
		while (i <= mid && j <= to) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= mid && i < a.length) {
			temp[k++] = a[i++];
		}
		for (i = from; i <= to; i++) {
			a[i] = temp[i];
		}
    	return;
    }
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    public static double[] mergeSortRecursive (double a[])
   {
    	double[] array = a.clone();
    	mergeSortRecursiveSorter(array, 0, array.length-1);
    	return array;
   }
    
   private static double[] mergeSortRecursiveSorter (double a[], int left, int right)
   {
	   if (left < right) 
       { 
           // Find the middle point 
           int mid = (left + right)/2; 
 
           // Sort first and second halves 
           mergeSortRecursiveSorter(a, left, mid); 
           mergeSortRecursiveSorter(a , mid + 1, right); 
 
           // Merge the sorted halves 
           mergeSortRecursiveMerger(a, left, mid, right); 
       } 
	   
	   return a;
   }
   
   private static void mergeSortRecursiveMerger (double a[], int l, int m, int r)
   {
	// Find sizes of two subarrays to be merged 
       int n1 = m - l + 1; 
       int n2 = r - m; 
 
       /* Create temp arrays */
       double leftArray[] = new double [n1]; 
       double rightArray[] = new double [n2]; 
 
       /*Copy data to temp arrays*/
       for (int i=0; i<n1; ++i) 
           leftArray[i] = a[l + i]; 
       for (int j=0; j<n2; ++j) 
           rightArray[j] = a[m + 1+ j]; 
 
 
       /* Merge the temp arrays */
 
       // Initial indexes of first and second subarrays 
       int i = 0, j = 0; 
 
       // Initial index of merged subarry array 
       int k = l; 
       while (i < n1 && j < n2) 
       { 
           if (leftArray[i] <= rightArray[j]) 
           { 
               a[k] = leftArray[i]; 
               i++; 
           } 
           else
           { 
               a[k] = rightArray[j]; 
               j++; 
           } 
           k++; 
       } 
 
       /* Copy remaining elements of L[] if any */
       while (i < n1) 
       { 
           a[k] = leftArray[i]; 
           i++; 
           k++; 
       } 
 
       /* Copy remaining elements of R[] if any */
       while (j < n2) 
       { 
           a[k] = rightArray[j]; 
           j++; 
           k++; 
       } 
   }
    
   public static boolean isSorted(double a[])
   {
	   for(int i = 1; i < a.length; i++)
	   {
		   if(a[i] < a[i-1])
		   {
			   return false;
		   }
	   }
	   return true;
   }


    public static void main(String[] args){

        //todo: do experiments as per assignment instructions
    }

 }//end class
