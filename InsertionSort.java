/* Insertion Sort Class inherits from Sort interface and takes in a double array, sorts it using insertion sort, then returns the amount of time the algorithm took.
 * Parameters: double of array size with random integers to sort
 * Returns: int of milliseconds insertion sort took
 * @author Clay Lee
 * @date September 17 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public class InsertionSort{
/*sort method takes in a double array and sorts it using insertion sort while keeping track of the amount of time taken
 * calls isSorted method
 * @param double[] of random and unsorted doubles
 * @return Long milliseconds that the sorting algorithm took to sort the given array
 */
  public Long sort(double[] array){
    Long startTime, endTime;
    startTime = System.currentTimeMillis();

    int n = array.length;
    for (int j = 1; j < n; j++) {
      double temp = array[j];
      int i = j-1;
      while ((i > -1) && (array [i] > temp ) ) {
        array[i+1] = array[i];
        i--;
      }
      array[i+1] = temp;
    }

    endTime = System.currentTimeMillis();
    if(isSorted(array)) return (endTime-startTime);
    else return -1L;
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
    InsertionSort ss = new InsertionSort();
    int arraySize = 10000;
    double[] arrayToSort = new double[arraySize];
    for(int i = 0; i < arraySize; i++){
      arrayToSort[i] = (double)(Math.random() * 500000);
    }
    System.out.println("insertion sort of " + arraySize + " took : " + ss.sort(arrayToSort) + " milliseconds");
    //System.out.println(Arrays.toString(arrayToSort));

  }
}
