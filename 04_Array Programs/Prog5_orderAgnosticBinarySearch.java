public class Prog5_orderAgnosticBinarySearch {
    public int binarySearch(int ar[], int key) {
        int start = 0, end = ar.length - 1;

        // Check if the array is sorted in ascending or descending order
        boolean isAscending = ar[start] < ar[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(ar[mid]); // Print mid element for debugging

            if (key == ar[mid])
                return mid; // Found key

            if (isAscending) { // Ascending order logic
                if (key < ar[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else { // Descending order logic
                if (key > ar[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        Prog5_orderAgnosticBinarySearch obj = new Prog5_orderAgnosticBinarySearch();

        int idx = obj.binarySearch(new int[]{8, 7, 6, 5, 4, 3, 2}, 8); // Works for descending
        // int idx = obj.binarySearch(new int[]{2, 3, 4, 5, 6, 7, 8}, 8); // Works for ascending

        if (idx == -1)
            System.out.println("Search NOT found");
        else
            System.out.println("Search found at index " + idx);
    }
}
