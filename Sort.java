/* Sort Class takes in a type of sorting and the size of array to sort then returns time took in milliseconds
 * Parameters: String of desired sort method, double of array size with random integers to sort
 * Returns: long of milliseconds the sort took
 * @author Clay Lee
 * @date September 17 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public interface Sort{

  public Long sort(double[] arrayToSort);
  public boolean isSorted(double[] array);

  public static void main(String[] args){
    int arraySize = Integer.parseInt(args[0]);

    double[] selectionArray = new double[arraySize];
    for(int i = 0; i < arraySize; i++){
      selectionArray[i] = (double)(Math.random() * 500000);
    }

    //double[] bubbleArray = Arrays.copyOf(selectionArray, arraySize);
    //double[] insertionArray = Arrays.copyOf(selectionArray, arraySize);
    double[] mergeArray = Arrays.copyOf(selectionArray, arraySize);
    double[] inMergeArray = Arrays.copyOf(selectionArray, arraySize);

    // SelectionSort ss = new SelectionSort();
    // BubbleSort bs = new BubbleSort();
    // InsertionSort is = new InsertionSort();
    MergeSort ms = new MergeSort();
    // QuickSort qs = new QuickSort();
    InPlaceMerge ip = new InPlaceMerge();

    // System.out.println("selection sort of " + arraySize + " took : " + ss.sort(selectionArray) + " milliseconds");
    // System.out.println("bubble sort of " + arraySize + " took : " + bs.sort(bubbleArray) + " milliseconds");
    // System.out.println("insertion sort of " + arraySize + " took : " + is.sort(insertionArray) + " milliseconds");
    System.out.println("merge sort of " + arraySize + " took : " + ms.sort(mergeArray) + " milliseconds");
    // System.out.println("quick sort of " + arraySize + " took : " + qs.sort(quickArray) + " milliseconds");
    System.out.println("in place merge sort of " + arraySize + " took : " + ip.sort(inMergeArray) + " milliseconds");

  }
}
