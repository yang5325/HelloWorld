package sort;

import java.util.Arrays;
import java.util.Collections;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr =new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }


        InsertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void InsertSort(int[] arr) {
        int insertVal ;
        int insertIndex ;
        for (int i = 1; i < arr.length; i++) {

            insertVal = arr[i];
            insertIndex = i - 1 ;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] =arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

        }

    }
}
