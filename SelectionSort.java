/* Selection Sort Class inherits from Sort interface and takes in a double array, sorts it using selection sort, then returns the amount of time in milliseconds the algorithm took.
 * Parameters: double of array size with random integers to sort
 * Returns: long of milliseconds selection sort took
 * @author Clay Lee
 * @date September 17 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public class SelectionSort implements Sort{
/*sort method takes in a double array and sorts it using selection sort while keeping track of the amount of time taken
 * calls swap method and isSorted method
 * @param double[] of random and unsorted doubles
 * @return Long milliseconds that the sorting algorithm took to sort the given array
 */
  public Long sort(double[] array){
    Long startTime, endTime;
    startTime = System.currentTimeMillis();

    int n = array.length;
    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n-1; i++){
      // Find the minimum element in unsorted array
      int jMin = i;
      for (int j = i+1; j < n; j++)
      if (array[j] < array[jMin]) jMin = j;
      swap(array, jMin, i);
    }

    endTime = System.currentTimeMillis();
    if(isSorted(array)) return (endTime-startTime);
    else return -1L;
  }
/*swap method takes in a double array to manipulate as well as the two indices for swapping
 * @param double[] array
 * @param int target index
 * @param int destination index
 */
  private void swap(double[] array, int targetIndex, int destinationIndex){
    double holder = array[destinationIndex];
    array[destinationIndex] = array[targetIndex];
    array[targetIndex] = holder;
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

  }
}
