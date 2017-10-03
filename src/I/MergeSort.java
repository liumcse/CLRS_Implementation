package I;

import java.util.Scanner;

public class MergeSort {
    public static void sort(int[] a, int p, int r) {
        if (p >= r) return;
        else {
            int mid = (p + r)/2;
            sort(a, p, mid);
            sort(a, mid + 1, r);
            merge(a, p, mid, r);
        }
    }

    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;  // n1 is the size of left array L
        int n2 = r - q;  // n2 is the size of right array R
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        /* initialize left and right arrays */
        for (int i = 0; i < n1; i++) L[i] = a[p + i];
        for (int i = 0; i < n2; i++) R[i] = a[q + i + 1];

        /* adopt a convention here */
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        /* merge with comparision */
        int i = 0, j = 0;  // i scans left array L, j scans right array R
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) a[k] = L[i++];
            else a[k] = R[j++];
        }
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
