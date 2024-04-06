public interface Sortable {
    void sort(int[] arr);
}

class BubbleSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        //int count =0;
        for(int turn = 0; turn<n-1; turn++){
            int swap = 0;
            for(int j=0; j<n-1-turn; j++){
                if(arr[j]>arr[j+1]){
                    swap++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //count++;
                }
            }
            if(swap==0){
                break;
            }
        }
    }
}

class SelectionSort implements Sortable{
    @Override
    public void sort(int[] arr){
        //int swap = 0;
        int n = arr.length;
        for(int i=0; i<n;i++){
            int min_pt = i;
            for(int j=i+1; j<n; j++){
                if(arr[min_pt]>arr[j]){
                    int temp = arr[min_pt];
                    arr[min_pt] = arr[j];
                    arr[j] = temp;
                    // swap++;
                }
            }
        }
    }
}

class MergeSort implements Sortable{

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else if (arr[j] < arr[i]) {
                temp[k++] = arr[j++];
            }
        }
        // for remaining elements
        // for left half
        while (i <= mid ) {
            temp[k++] = arr[i++];
        }
        // for right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (k = 0, i = left; i <= right; k++, i++) { // don't write i<temp.length because This will cause an ArrayIndexOutOfBoundsException because temp might have a different length than the range left to right in the original array.To fix this, you should update the loop condition to i <= right. This ensures that you only copy the merged elements back to the correct range in the original array.
            arr[i] = temp[k];
        }
    }
}

class Sorter{
    void sort(Sortable algorithm, int[] arr){
        algorithm.sort(arr);
    }
}