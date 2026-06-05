public class BubbleSort {
    static void swap(int[] arr, int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    static void Bsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int flag=0;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    flag++;
                    swap(arr, i, j);
                }
            }
            if(flag==0)break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2 };

        Bsort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
