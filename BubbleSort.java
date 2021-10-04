/* Bubble Sort Class inherits from Sort interface and takes in a double array, sorts it using bubble sort, then returns the amount of time in milliseconds the algorithm took.
 * Parameters: double of array size with random integers to sort
 * Returns: int of milliseconds bubble sort took
 * @author Clay Lee
 * @date September 17 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public class BubbleSort{

  public Long sort(double[] array){
    Long startTime, endTime;
    startTime = System.currentTimeMillis();

    int n = array.length;
    int temp = 0;
    for(int i=0; i < n; i++){
      for(int j=1; j < (n-i); j++){
        if(array[j-1] > array[j]) swap(array, j-1, j);
      }
    }

    endTime = System.currentTimeMillis();
    if(isSorted(array)) return (endTime-startTime);
    else return -1L;
  }
/*swap method takes in a double array to manipulate as well as the two indices for swapping
 * @param double[] of random and unsorted doubles
 * @param int target index
 * @param int destination index
 */
  private boolean swap(double[] array, int targetIndex, int destinationIndex){
    double holder = array[destinationIndex];
    array[destinationIndex] = array[targetIndex];
    array[targetIndex] = holder;
    return true;
  }
/*isSorted method takes in a double array and iterates to check if it is sorted in ascending order and returns true if it is
 * @param double[] array
 * @return boolean, whether the array is sorted in ascending order
 */
 public boolean isSorted(double[] array){
   for (int i = 0; i < array.length - 1; i++){
     if (array[i] > array[i + 1])
     return false;
   }
   return true;
 }

  public static void main(String[] args){
    BubbleSort ss = new BubbleSort();
    int arraySize = 100;
    double[] arrayToSort = new double[arraySize];
    for(int i = 0; i < arraySize; i++){
      arrayToSort[i] = (double)(Math.random() * 500000);
    }
    System.out.println("bubble sort of " + arraySize + " took : " + ss.sort(arrayToSort) + " milliseconds");
    //System.out.println(Arrays.toString(arrayToSort));

  }
}
