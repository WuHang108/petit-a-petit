import java.util.*;

public class MergeSort {
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int i = low;// 左指针
        int j = mid;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i < mid && j < high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i < mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j < high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public static void mergeSort(int[] a, int low, int high, int partLength, int numOfParts) {
        if(numOfParts <= 1) {
            return ;
        }
        int mid = low + partLength*(numOfParts/2);
        if (low < high) {
            // 左边
            mergeSort(a, low, mid, partLength, numOfParts/2);
            // 右边
            mergeSort(a, mid, high, partLength, numOfParts-numOfParts/2);
            // 左右归并
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void partlyMergeSort(int[] arr) {
        int partLength = 0;
        while(arr[partLength] < arr[partLength+1]) {
            partLength++;
        }
        partLength++;
        int numOfParts = arr.length / partLength;
        mergeSort(arr, 0, arr.length, partLength, numOfParts);
    }

    public static void main(String[] args) {
        int a[] = { 18, 46, 51, 20, 65, 97, 30, 77, 82 };
        partlyMergeSort(a);
        System.out.println("部分有序数组排序结果：" + Arrays.toString(a));
    }
}
