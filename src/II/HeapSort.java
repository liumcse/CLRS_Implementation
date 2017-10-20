package II;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        int length;
        Scanner sc = new Scanner(System.in);

        /* get length */
        System.out.println("Please enter the length of array:");
        length = sc.nextInt();
        int a[] = new int[length];

        /* get array */
        System.out.println("Please enter " + length + " numbers:");
        for (int i = 0; i < length; i++) a[i] = sc.nextInt();

        /* sort */
        MaxHeap maxHeap = new MaxHeap(a);
        // note that it's a maxHeap, so additional operation needed:
        for (int i = length - 1; i >= 0; i--) a[i] = maxHeap.getMax();

        /* print array */
        for (int i = 0; i < length; i++) System.out.print(a[i] + " ");
    }
}

class MaxHeap {
    private int[] heap;
    private int heapSize;

    MaxHeap(int[] A) {
        heapSize = A.length;
        heap = new int[heapSize + 1];

        // insert elements in A to heap, heapify later
        for (int i = 1; i <= heapSize; i++) heap[i] = A[i - 1];

        // heapify
        for (int i = heapSize / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    public int getMax() {
        // get the max
        int max = heap[1];
        // swap the last element with the first
        swap(1, heapSize);
        // fix the heap
        heapSize--;
        heapify(1);
        // return max
        return max;
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;

        /* --- find the largest value among left, right and parent --- */
        if (l <= heapSize && heap[l] > heap[i]) {
            // whether left child is greater than parent
            largest = l;
        }
        else largest = i;

        if (r <= heapSize && heap[r] > heap[largest]) {
            // whether right child is greater than the largest so far
            largest = r;
        }
        /* --- find the largest value among left, right and parent --- */

        if (largest != i) {
            // if the parent is not the largest, heapify needed
            swap(largest, i);
            // apply heapify again, to the lower level
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

}