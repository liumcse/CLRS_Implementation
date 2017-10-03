package I;

import java.util.Scanner;

public class InsertionSort {
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
        sort(a, length);

        /* print array */
        for (int i = 0; i < length; i++) System.out.print(a[i] + " ");
    }

    public static void sort(int[] a, int length) {
        for (int j = 1; j < length; j++) {
            int key = a[j];  // j scans from j to right
            int i = j - 1;  // i scans from j to left

            /* move the key to the left until it finds a place to fit in */
            while (i >= 0 && a[i] > key) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
}
