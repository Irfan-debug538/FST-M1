import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        
        int[] arr = {9, 5, 1, 4, 3};

        
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        
        insertionSort(arr);

        
        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        
        for (int i = 1; i < n; i++) {
            int key = arr[i];  
            int j = i - 1;

            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            arr[j + 1] = key;
        }
    }
}
