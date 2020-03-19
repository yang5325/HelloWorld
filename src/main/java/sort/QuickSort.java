package sort;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class QuickSort {
    public static void main(String[] args) {
        //       int[] arr = {9, 8, 3, 6, 5, 4, 7, 2, 1};
        int[] arr =new int[9];
        for (int k=0,i = arr.length-1; i >=0; i--) {
            arr[k++] = i;
        }
        System.out.println(Arrays.toString(arr));
        quickSort_知乎(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    //B乎
    public static void quickSort_知乎(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        //得到一个中轴值的索引、使左边的都比arr[pivot]小、右边的都比arr[pivot]大
        //      int pivot = partition2(arr, low, high);
        int pivot = partition(arr, low, high);
        quickSort_知乎(arr, low, pivot - 1);
        quickSort_知乎(arr, pivot + 1, high);
    }

    //某书
    public static int partition2(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        int x = arr[low++];
        while (low <= high) {
            while (low <= high && arr[high] >= x) {
                high--;
            }
            while (low <= high && arr[low] <= x) {
                low++;
            }
            if (low < high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        arr[left] = arr[high];
        arr[high] = x;
        return high;
    }

    /**
     * B乎排序
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //作为基准
        while (low < high) {
            //数组右边的值大于基准值 代表有序 则high--
            while (arr[high] >= pivot && low < high) {
                high--;
            }
            //在右端找到了一个比基准值小的
            arr[low] = arr[high]; //将该值替换到low端

            while (arr[low] <= pivot && low < high) {
                low++;
            }
            //在左端找到一个比基准值大的
            arr[high] = arr[low];   //将该值替换到右端
        }

        arr[high] = pivot;
        return high; //返回准值的索引
    }



/*    private static int partiton(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low < high){
            if(low < high){
                int tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
            }
            while (arr[low] <= pivot && low <high){
                low++;
            }
            while (arr[high] >= pivot && high > low){
                high--;
            }
        }
        return high;
    }*/



    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int poivt = arr[(l + r) / 2];
        //int poivt = arr[left]; //取此基准亦可
        int tmp;   //临时变量、作交换数据用
        while (l < r) {
            while (arr[l] < poivt) {
                l++;
            }
            while (arr[r] > poivt) {
                r--;
            }
            //两次while循环后、如果l>=r条件满足、则代表poivt值的左右两边均有序、否则进行值的交换
            if (l >= r) {
                break;
            } else {
                tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
            }
            //如果交换完 arr[l]或者arr[r]的值等于poivt
            if (arr[l] == poivt) {
                l--;
            }
            if (arr[r] == poivt) {
                r--;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }


}
