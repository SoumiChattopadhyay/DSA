import java.util.Arrays;

public class Prog32_Merge_2_Sorted_Arrays_without_extra_space {
    // Brute
    static void funct1(int[] arr1, int[] arr2){//2 sorted arrays given
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n+m];
        int left=0, right=0;//2 pointers pointing at arr1 and arr2 
        int index=0;//points at 3rd array
        
        // Put all els in sorted order in 3rd array
        while(left<n && right<m){
            if(arr1[left]<arr2[right]){
                arr3[index] = arr1[left];
                left++;
                index++;
            }else{
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }

        // Put remaining els (if any) of arr1 into arr3
        while(left<n){
            arr3[index++] = arr1[left++];
        }

        // Put remaining els (if any) of arr2 into arr3
        while(right<m){
            arr3[index++] = arr2[right++];
        }

        // Replace els of arr1 and arr2 with els of arr3
        for(int i=0;i<n+m;i++){
            if(i<n) arr1[i] = arr3[i];
            else arr2[i-n] = arr3[i];
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    // Optimal Soln 1
    static void funct2(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                swap(arr1[left],arr2[right]);
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
    }

    // Optimal Soln 2(Gap Method derived from Shell Algorithm)
    static void funct3(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int len=n+m;
        int gap=(len/2)+(len%2);
        
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                // left in arr1 and right in arr2
                if(left<n && right>=n){
                    swapWhenGreater(left, right-n, arr1, arr2);
                }
                // left and right in arr2
                else if(left>=n && right>=n){
                    swapWhenGreater(left-n, right-n, arr1, arr2);
                }
                // left and right in arr1
                else{
                    swapWhenGreater(left, right, arr1, arr2);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap=(gap/2)+(gap%2);
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    static void swapWhenGreater(int left, int right, int[] arr1, int[] arr2){
        if(arr1[left]>arr2[right]){
            int temp=arr1[left];
            arr1[left]=arr2[right];
            arr2[right]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {0,2,6,8,9};
        funct1(arr1, arr2);
        funct2(arr1, arr2);
        funct3(arr1, arr2);
    }
}
