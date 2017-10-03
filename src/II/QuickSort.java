package II;

import java.util.Scanner;

public class QuickSort {
    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    public static int partition(int[] a, int p, int r) {
        // in this implementation, we choose a[r] as pivot
        int pivot = a[r];
        int i = -1;  // i is (approx.) the index where the pivot should finally go to
        // scan through the array
        for (int j = 0; j < r; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        // now i + 1 is the index where the pivot should go
        swap(a, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

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
        sort(a, 0, length - 1);

        /* print array */
        for (int i = 0; i < length; i++) System.out.print(a[i] + " ");
    }
}