public class Prog01_Min_and_Max_in_Array {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 6};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
    }
}
