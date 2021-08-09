import java.util.Arrays;

public class SortArray {
    public static int[] testSearch(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1 ;j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,9234,987,12,65,63,236};
        System.out.println(Arrays.toString(testSearch(arr)));
    }
}
