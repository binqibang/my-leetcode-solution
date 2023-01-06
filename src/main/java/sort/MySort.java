package sort;

public class MySort {
    private boolean less(int a, int b) {
        return a < b;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 简单选择排序
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(1)
     * @param arr 待排序数组，简便起见为 int 型
     */
    public void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[minIdx])) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    /**
     * 冒泡排序
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(1)
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean sorted = false;
        for (int i = n - 1; i > 0 && !sorted; i--) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    sorted = false;
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 直接插入排序
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(1)
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                swap(arr, j, j-1);
            }
        }
    }

    /**
     * 希尔排序
     * @TimeComplexity O(n) ~ O(n^2)
     * @SpaceComplexity O(1)
     */
    public void shellSort(int[] arr) {
        int n = arr.length, h = 1;
        while (h < n / 3) {
            // 1, 4, 13, 40, ...
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }

    private void merge(int[] arr, int[] aux, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1;
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        for (int i = left; i <= right; i++) {
            if (p1 > mid) {
                arr[i] = aux[p2++];
            } else if (p2 > right) {
                arr[i] = aux[p1++];
            } else if (aux[p1] <= aux[p2]) {
                arr[i] = aux[p1++];
            } else {
                arr[i] = aux[p2++];
            }
        }
    }

    private void mergeSort(int[] arr, int[] aux, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }

    /**
     * 自顶向下归并
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public void topDownMergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left], i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    private void qsort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        qsort(arr, left, mid - 1);
        qsort(arr, mid + 1, right);
    }

    public void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }
}
