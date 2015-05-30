import java.util.*;

public class Sorts{
  public void bubbleSort(int[] list){
    for (int i = 0; i < list.length; i ++){
      for (int j = 0; j < list.length - i - 1; j ++){
        if (list[j] > list[j + 1]) {
          int temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
        }
      }
    }
  }
  public void selectionSort(int[] list){
    int marker, temp;
    for (int outer = 0; outer < list.length - 1; outer++){
      marker = outer;
      for (int inner = outer + 1; inner < list.length; inner ++){
        if (list[inner] < list[marker]) {
          marker = inner;
        }
      }
      temp = list[outer];
      list[outer] = list[marker];
      list[marker] = temp;
    }
  }
  public void insertionSort(int[] list){
    for (int outer = 1; outer < list.length; outer ++){
      int position = outer;
      int key = list[position];
      while (position > 0 && key < list[position - 1]){
        list[position] = list[position - 1];
        position --;
      }
      list[position] = key;
    }   
  }
  private void merge(int[] a, int first, int mid, int last){
    int[] b = new int[a.length];
    for (int j = first; j <= last; j ++){
      b[j] = a[j];
    }
    int nA = first;
    int nB = mid + 1;
    for (int i = first; i <= last; i ++){
      if (nA > mid) {
        b[i] = a[nB];
        nA ++;
      } else if (nB > last){
        b[i] = a[nA];
        nB ++;
      } else if (a[nA] > a[nB]){
        b[i] = a[nB];
        nB ++;
      } else {
        b[i] = a[nA];
        nA ++;
      }
    }
    for (int j = first; j <= last; j ++){
      a[j] = b[j];
    }
  }
  public void mergeSort(int[] a, int first, int last){
    int mid = (first + last)/2;
    if (first != last){
      mergeSort(a, first, mid);
      mergeSort(a, mid + 1, last);
    }
    merge(a, first, mid, last);
  }
}
