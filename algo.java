public static int[] mergeAndSort(int[] firstArray, int[] secondArray) {
    int length1 = firstArray.length;
    int length2 = secondArray.length;

    int[] mergedArray = new int[length1 + length2];

    System.arraycopy(firstArray, 0, mergedArray, 0, length1);
    System.arraycopy(secondArray, 0, mergedArray, length1, length2);
    bubbleSort(mergedArray);

    return mergedArray;
}

public static void bubbleSort(int[] arr) {
    boolean isSorted = false;
    while (!isSorted) {
        isSorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                isSorted = false;
            }
        }
    }
}
