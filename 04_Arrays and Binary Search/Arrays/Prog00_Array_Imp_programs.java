import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
public class Prog00_Array_Imp_programs {
    // Left Rotate array by 1 place
    // TC=O(N), SC=O(1)
    static int[] leftRotatebyOne(int[] arr, int n){
        int last = arr[0];
        for(int i=1;i<=n-1;i++){//Shift els from idx 1 to n-1 to the left TC=O(N)
            arr[i-1]=arr[i];
        }
        arr[n-1]=last;
        return arr;
    }
    // Left Rotate array by D places
    // Brute, TC=O(N+D), SC=O(D)
    static int[] leftRotatebyD_1(int[] arr, int n, int D){
        D%=n;
        int last[] = new int[D];
        for(int i=0;i<D;i++){//Copy first D els to another array, TC=O(D)
            last[i]=arr[i];
        }
        for(int i=D;i<n;i++){//Shift els from idx D to n-1 to the left, TC=O(N-D)
            arr[i-D]=arr[i];
        }
        for(int i=n-D;i<n;i++){//Add the copied D els to the last, TC=O(D)
            arr[i]=last[i-(n-D)];
        }
        return arr;
    }
    // Optimal, TC=O(N), SC=O(1)
    static int[] leftRotatebyD_2(int[] arr, int n, int D){
        D%=n;
        reverse(arr, 0, D-1);//Reverse first D els, TC=O(D)
        reverse(arr, D, n-1);//Reverse els from idx D to n-1, TC=O(N-D)
        reverse(arr, 0, n-1);//Reverse entire array, TC=O(N)
        return arr;
    }
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    // Move zeroes to end
    // Brute, TC=O(N), SC=O(N) as in worst case k=N
    static void move0sToEnd_1(int[] arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){//copy non-zero els to another list. We took list becoz we dont know the exact size
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }
        int k=temp.size();
        for(int i=0;i<k;i++){//put the copied els in the front of the array
            arr[i]=temp.get(i);
        }
        for(int i=k;i<n;i++){//fill remaining positions with 0
            arr[i]=0;
        }
    }
    // Optimal, TC=O(N),SC=O(1)
    static void move0sToEnd_2(int[] arr, int n){
        int j=-1;
        for(int i=0;i<n;i++){//make j point to the first 0, TC=O(x)
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;//means no 0s present in the array
        for(int i=j+1;i<n;i++){//Start looping from j+1, TC=O(N-x)
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }
    // Linear Search TC=O(N),SC=O(1)
    static int linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Union of Two Sorted Arrays
    // Brute, TC=O(N1 log N)+O(N2 log N)+O(N1+N2), SC=2*O(N1+N2)
    static ArrayList<Integer> union_1(int[] arr1, int[] arr2){//You may use array also 
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:arr1) set.add(num); //O(N1 log N)
        for(int num:arr2) set.add(num);//O(N2 log N)
        return new ArrayList<>(set);//O(N1+N2)
    }
    // Optimal, TC=O(N1+N2), SC=O(N1+N2)
    static ArrayList<Integer> union_2(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        ArrayList<Integer> union = new ArrayList<>();
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr1[i]){//if el at end of arraylist same as arr1[i] then it is duplicate dont insert it
                    union.add(arr1[i]);
                }
                i++;
            }
            else{
                if(union.size()==0 || union.get(union.size()-1)!=arr2[j]){//if el at end of arraylist same as arr2[j] then it is duplicate dont insert it
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n1){//insert(if any) remaining els of arr1
            if(union.size()==0 || arr1[i]!=union.get(union.size()-1)){
                union.add(arr1[i]);
            }
            i++;
        }
        while(j<n2){//insert(if any) remaining els of arr2
            if(union.size()==0 || arr2[j]!=union.get(union.size()-1)){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
    // Intersection of Two Sorted Arrays
    // Brute, TC=O(N1 * N2), SC=O(N2)
    static ArrayList<Integer> intersection_1(int[] arr1, int[] arr2){//You may use array also 
        int n1=arr1.length;
        int n2=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n2];//or if you keep visited array for n1, the i loop runs till n2 and j loop runs till n1
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(arr1[i]==arr2[j] && !visited[j]){
                    ans.add(arr1[i]);
                    visited[j]=true;
                    break;
                }
                if(arr2[j]>arr1[i]){//we have exceeded, so you will never find equal el, so stop j loop
                    break;
                }
            }
        }
        return ans;
    }
    // Optimal, TC=O(N1+N2), SC=O(1)
    static ArrayList<Integer> intersection_2(int[] arr1, int[] arr2){//You may use array also 
        int n1=arr1.length;
        int n2=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyOne(arr,n)));
        
        arr = new int[]{1,2,3,4,5,6,7};
        n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyD_1(arr,n,2)));

        arr = new int[]{1,2,3,4,5,6,7};
        n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyD_2(arr,n,2)));

        arr = new int[]{1,0,2,3,2,0,0,4,5,1};
        n=arr.length;
        move0sToEnd_1(arr,n);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1,0,2,3,2,0,0,4,5,1};
        n=arr.length;
        move0sToEnd_2(arr,n);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4,5,7,2,9};
        System.out.println(linearSearch(arr,2));

        int[] arr1 = {1, 1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 4, 4, 5, 6};
        System.out.println(union_1(arr1, arr2));
        System.out.println(union_2(arr1, arr2));

        arr1 = new int[]{};// empty, so first while loop doesnt run as no comparison b/w arr1 and arr2 possible so in 2nd while loop union.get(union.size()-1) evaluates to union.get(0-1) i.e. union.get(-1) so we might get error so union.size()==0 || union.get(...) is necessary, so in 2nd while loop when union size is 0 it tries to insert but since arr1[i] is nothing so skips everytime then in 3rd loop again when union size 0 but inserts all els of arr2 
        arr2 = new int[]{5, 7, 9};
        System.out.println(union_2(arr1, arr2));

        arr1 = new int[]{1, 1, 2, 2, 3, 4, 5};
        arr2 = new int[]{2, 2, 3, 4, 4, 5, 6};
        System.out.println(intersection_1(arr1, arr2));
        System.out.println(intersection_2(arr1, arr2));
    }
}