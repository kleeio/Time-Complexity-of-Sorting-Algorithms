/* Quick sort implements Sort class and takes in a double array, sorts it, then returns the amount of time in milliseconds taken to sort the given array
* Parameter: an array of doubles
* Returns: long of milliseconds the sort took
* @author Clay Lee
* @date October 1 2021
* CS245 Data Structures and Algorithm Assignment 1
* Professor Brizan
*/
import java.util.*;
public class QuickSort implements Sort{
  /* public sort method takes in a double array, which calls the private sort method then returns the milliseconds taken to sort
  * calls private sort method
  * @param double[] of random and unsorted doubles
  * @return Long, amount of milliseconds that merge sort took
  */
  public Long sort(double[] array) {
    Long startTime, endTime;
    startTime = System.currentTimeMillis();

    QuickSort(array, 0, array.length - 1);

    endTime = System.currentTimeMillis();
    if(isSorted(array)) return (endTime-startTime);
    else return -1L;
  }
  /* Partition method repeatedly picks the left most element as the pivot and partitions recursively to sort
  * @param double[] of random and unsorted doubles
  * @return Long, amount of milliseconds that merge sort took
  */
  private void QuickSort(double array[], int left, int right) {
    if(left >= right) return;
    int mid = Partition(array, left, right);
    QuickSort(array, left, mid);
    QuickSort(array, mid + 1, right);
  }

  private int Partition(double[] array, int left, int right) {
    double pivot = array[left];
    while(left < right) {
      while (left < right && array[right] >= pivot) right--;
      Swap(array, left, right);
      while (left < right && array[left] <= pivot) left++;
      Swap(array, right, left);
    }
    array[left] = pivot;
    return left;
  }
  /*swap method takes in a double array to manipulate as well as the two indices for swapping
  * @param double[] array
  * @param int target index
  * @param int destination index
  */
  private void Swap(double[] array, int left, int right) {
    double temp = array[left];
    array[left] = array[right];
    array[right] = temp;
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
    // QuickSort ss = new QuickSort();
    // int arraySize = 900000;
    // double[] arrayToSort = new double[arraySize];
    // for(int i = 0; i < arraySize; i++){
    //   arrayToSort[i] = (double)(Math.random() * 50000);
    // }
    // System.out.println("quick sort of "+ arrayToSort.length + " took " + ss.sort(arrayToSort) + " milliseconds");
    //System.out.println(Arrays.toString(arrayToSort));
  }
}
