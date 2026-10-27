import java.util.Arrays;

public class Practice3 {

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 7, 3};
        OptimizedBubbleSorter.sort(arr1, true);
        System.out.println("Bubble (true):    " + Arrays.toString(arr1));

        int[] arr2 = {5, 2, 9, 1, 7, 3};
        InsertionSorter.sort(arr2, false);
        System.out.println("Insertion (false): " + Arrays.toString(arr2));
    }

    public static class OptimizedBubbleSorter {
        public static void sort(int[] array, boolean ascending) {
            if (array == null || array.length <= 1) {
                return;
            }

            for (int i = 0; i < array.length - 1; i++) {
                boolean swapped = false;

                for (int j = 0; j < array.length - 1 - i; j++) {
                    boolean shouldSwap = ascending ? array[j] > array[j + 1] : array[j] < array[j + 1];
                    if (shouldSwap) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                        swapped = true;
                    }
                }

                if (!swapped) {
                    break;
                }
            }
        }
    }

    public static class InsertionSorter {
        public static void sort(int[] array, boolean ascending) {
            if (array == null || array.length <= 1) {
                return;
            }

            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && (ascending ? array[j] > key : array[j] < key)) {
                    array[j + 1] = array[j];
                    j--;
                }

                array[j + 1] = key;
            }
        }
    }

    public static class SelectionSorter {
        public static void sort(int[] array, boolean ascending) {
            if (array == null || array.length <= 1) {
                return;
            }

            for (int i = 0; i < array.length - 1; i++) {
                int targetIndex = i;

                for (int j = i + 1; j < array.length; j++) {
                    boolean shouldUpdate = ascending
                            ? array[j] < array[targetIndex]
                            : array[j] > array[targetIndex];

                    if (shouldUpdate) {
                        targetIndex = j;
                    }
                }

                if (targetIndex != i) {
                    int tmp = array[i];
                    array[i] = array[targetIndex];
                    array[targetIndex] = tmp;
                }
            }
        }
    }
}
