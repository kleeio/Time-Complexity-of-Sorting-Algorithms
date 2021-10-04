/* Merge sort implements Sort class and takes in a double array, sorts it, then returns the amount of time in milliseconds taken to sort the given array
 * Parameter: an array of doubles
 * Returns: long of milliseconds the sort took
 * @author Clay Lee
 * @date October 1 2021
 * CS245 Data Structures and Algorithm Assignment 1
 * Professor Brizan
 */
import java.util.*;
public class MergeSort implements Sort{
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
  private void mergeSort(double[] array, int low, int high){
    if (low >= high)
    return ;
    int mid = (low + high) >>> 1;
    mergeSort(array, low, mid);
    mergeSort(array, mid + 1, high);
    merge(array, low, mid, mid + 1, high);
  }
 /*merge method takes in a double array as well as three indices to track position in array
  * calls private sort method
  * @param double[] of sorted doubles
  * @param index to track left side lower index
  * @param index to track left side higher index
  * @param index to track right side lower index
  * @param index to track right side higher index
  * @return Long, amount of milliseconds that merge sort took
  */
  private void merge(double[] array, int leftLow, int leftHigh, int rightLow, int rightHigh){
    if (leftLow == rightHigh)
    return;
    int low = leftLow;
    int high = rightHigh;

    double[] tempArray = new double[leftHigh - leftLow + 1 + rightHigh - rightLow + 1];
    int index = 0;
    while(leftLow <= leftHigh && rightLow <= rightHigh){
      tempArray[index++] = (array[leftLow] < array[rightLow]) ? array[leftLow++] : array[rightLow++];
    }
    while(leftLow <= leftHigh){
      tempArray[index++] = array[leftLow++];
    }
    while(rightLow <= rightHigh){
      tempArray[index++] = array[rightLow++];
    }
    index = 0;
    while (low <= high){
      array[low++] = tempArray[index++];
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
    // MergeSort ms = new MergeSort();
    // int arraySize = 1000000;
    // double[] arrayToSort = new double[arraySize];
    // for(int i = 0; i < arraySize; i++){
    //   arrayToSort[i] = (double)(Math.random() * 500000);
    // }
    // System.out.println("merge sort of " + arraySize + " took : " + ms.sort(arrayToSort) + " milliseconds");
    //System.out.println(Arrays.toString(arrayToSort));
  }
}
