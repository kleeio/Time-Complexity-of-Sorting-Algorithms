/* In Place merge sort implements Sort class and takes in a double array, sorts it, then returns the amount of time in milliseconds taken to sort the given array
 * Parameter: an array of doubles
 * Returns: long of milliseconds the sort took
 * @author Clay Lee
 * @date October 1 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public class InPlaceMerge implements Sort{
  /*public sort method takes in a double array, which calls the private sort method then returns the milliseconds taken to sort
  * calls private sort method
  * @param double[] of random and unsorted doubles
  * @return Long, amount of milliseconds that merge sort took
  */
  public Long sort(double[] array){
    Long startTime, endTime;
    startTime = System.currentTimeMillis();

    mergeSort(array, 0, array.length - 1);

    endTime = System.currentTimeMillis();
    if(isSorted(array)) return (endTime-startTime);
    else return -1L;
  }
  /*private sort method takes in a double array, which calls the private sort method that is often called the mergesort method; returns the milliseconds taken to sort
   * @param double[] of random and unsorted doubles
   * @return Long, amount of milliseconds that merge sort took
   */
  private void mergeSort(double array[], int left, int right){
    if (left < right) {//pointers have not intersect; continue merge

      int mid = left + (right-left) / 2;

      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      merge(array, left, mid, right);
    }
  }
  /* private merge method called by sort method.
  * @param double[] of random and unsorted doubles
  * @return Long, amount of milliseconds that merge sort took
  */
  private void merge(double array[], int low, int mid, int high){
    int midHigh = mid + 1;
    if (array[mid] <= array[midHigh]){//already sorted
      return;
    }
    // low to mid is the first array, midHigh to high is the second;when they cross, merge is done
    while(low <= mid && midHigh <= high){
      if(array[low] <= array[midHigh]){//first array is lower and element is at the right index
        low++;
      }
      else {//insert element at midHigh to index low and shift all elements back; index stores the start of second array
        double temp = array[midHigh];
        int index = midHigh;

        while (index != low) {
          array[index] = array[index-1];
          index--;
        }
        array[low++] = temp;
        mid++;
        midHigh++;
      }
    }
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
    // InPlaceMerge ms = new InPlaceMerge();
    // int arraySize = 1000000;
    // double[] arrayToSort = new double[arraySize];
    // for(int i = 0; i < arraySize; i++){
    //   arrayToSort[i] = (double)(Math.random() * 500000);
    // }
    // System.out.println("in-place merge sort of " + arraySize + " took : " + ms.sort(arrayToSort) + " milliseconds");
    //System.out.println(Arrays.toString(arrayToSort));
  }
}
