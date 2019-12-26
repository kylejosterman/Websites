//Sorting

/**Objects in Array/Collection must be Comparabale 
Selection Sort - Look for smallest element, move to front
    - O(n^2)
Bubble Sort - Swap adjacent pairs that are out of order
    - O(n^2)
Insertion Sort - Build an increasingly large sorted front portion
    - O(n^2)
Merge Sort - Recursively divide array in half and sort it
Heap Sort - Place values into a sorted tree structure
Qucik Sort - Recursively partition array based on a middle values
Bucket Sort - Cluster elements into smaller groups and sort them
Radix Sort - Sort integers by last digit, then 2nd to last, etc. */

public static void selectionSort(int[] a) {
    int min = a[0];
    int temp;
    int minPos;
    for (int i = 0; i < a.lenth; i++) {
        min = a[i];
        for (int j = i + 1; j < a.length; i++) {
            if (a[i] < a[j]) {
                min = arr[j];
            }
            arr[i] = min;
        }
    }
    temp = a[i];
    a[i] = a[minPos];
    a[minPos] = temp;;
}

public static void selectionSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < a[min]) {
                min = j;
            }
        }
        swap(a, i, min);
    }
}
public static void swap(int[] a, int i, int min) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

/**Insertion 
    1. Pick value from collection 
    2. Scan sorted values looking for smaller one
    3. If smaller one found, insert new value after it
    4. Repeat

    Recursive: Break list into first and all but first, until reach one item. Insert each first item into sublist

Merge Sort 
    1. Divide list into two halves
    2. Sort left
    3. Sort right
    4. Merge two sorted half*/

// Merge
public static void merge(int[] result, int[] left, int[] right) {
    int i1 = 0;
    int i2 = 0;

    for (int i = 0; i < result.length; i++) {
        if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
            result[i] = left[i1]; // Take from left
            i1++;
        } else {
            result[i] = right[i2]; // Take from right
            i2++;
        }
    }
}

public static void mergeSort(int[] a) {
    if (a.length >= 2) {
        // Split
        int[] left = Arrays.copyOfRange(a, 0, a.length/2);
        int[] right = Arrays.copyOfRange(a, a.length/2, a.length);
        // Sort
        mergeSort(left);
        mergeSort(right);

        // Merge sorted halves into sorted whole
        merge(a, left, right);
    }
}

/** Quick Sort
  1. Use pivot element to break list into smaller parts. Select first element.
   2. Scan through elements
       a. Move smaller elements to first sublist
       b. Move larger elements to second sublist
   3. Quick sort sublists
  
    O(n log(n)) - Faster than mergeSort
    Worst-case: O(n^2) - Already sorted array
 */