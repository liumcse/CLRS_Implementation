package II;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition_mid(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    public static void sort_randomized(int[] a, int p, int r) {
        if (p < r) {
            int q = partition_randomized(a, p, r);
            sort_randomized(a, p, q - 1);
            sort_randomized(a, q + 1, r);
        }
    }

    public static int partition(int[] a, int p, int r) {
        // in this implementation, we choose a[r] as pivot
        int pivot = a[r];
        int i = p - 1;  // i + 1 is the index where the pivot should finally go to
        // scan through the array
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        // now i + 1 is the index where the pivot should go
        swap(a, i + 1, r);
        return i + 1;
    }

    public static int partition_mid(int[] a, int p, int r) {
        // in this implementation, we choose the mid point as pivot
        // This is in accordance with CZ2001
        int mid = (p + r)/2;
        swap(a, p, mid);  // critical step
        int pivot = a[p];
        int i = p;
        for (int j = p + 1; j <= r; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i, p);
        return i;
    }

    public static int partition_randomized(int[] a, int p, int r) {
        // in this implementation, we choose the pivot randomly
        Random rand = new Random();
        int pivotPos = rand.nextInt(r - p + 1) + p;
        swap(a, pivotPos, r);
        int pivot = a[r];
        int i = p - 1;  // i + 1 is the index where the pivot should finally go to
        // scan through the array
        for (int j = p; j < r; j++) {
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

        System.out.println("Normal QuickSort:");
        /* sort */
        sort(a, 0, length - 1);

        /* print array */
        for (int i = 0; i < length; i++) System.out.print(a[i] + " ");

        System.out.println("\nRandomized QuickSort");
        /* sort */
        sort(a, 0, length - 1);

        /* print array */
        for (int i = 0; i < length; i++) System.out.print(a[i] + " ");
    }
}