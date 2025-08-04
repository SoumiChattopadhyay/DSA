public class Prog5_smallestCharGreaterthanTarget {
        public static char nextGreatestLetter(char[] letters, char target) {
            int start=0, end=letters.length-1;
            if(target>=letters[end]){
                return letters[0];
            }
            while(start<=end){//Implicit conversion from char to int is happening
                int mid=start+(end-start)/2;
                if(target<letters[mid])
                    end=mid-1;
                else if(target>=letters[mid])// i have to return the next greatest so if its = go beyond not behind that
                    start=mid+1;
            }
            return letters[start];
            //return letters[start % letters.length]; if u write this no need of first if case
        }//2%4=2
        //4%4=0//In ceiling problem if target>arr[arr.length-1] we returned -1. but here if this happens we need to return the first el 
        //6%4=2//wont happen
    public static void main(String[] args) {
        char[] arr = {'c','f','g'};//array has atleast two letters. so if target>arr.length-1 then return -1 condn not needed
        char target = 'f';
        System.out.println(Prog5_smallestCharGreaterthanTarget.nextGreatestLetter(arr, target));
    }
}

