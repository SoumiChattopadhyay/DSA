public class Prog2_remove_even {
    public int[] removeEven(int ar[]){
        int i, oddLength=0,idx=0;
       //find length of array which will contain only odd elements
       for(i=0;i<ar.length;i++){
        if(ar[i]%2!=0){
            oddLength++;
        }
       }
       //create the new array which will contain only odd elements
       int result[]=new int[oddLength];

       //assign the odd values from the old array to the new array
       for(i=0;i<ar.length;i++){
        if(ar[i]%2!=0){
            result[idx]=ar[i];
            idx++;
        }
       }
       return result;
    }
    public void printArray(int result[]){
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public static void main(String[] args) {
        //creating object to call the methods
        Prog2_remove_even obj = new Prog2_remove_even();
        int result[]=obj.removeEven(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        obj.printArray(result);
    }
}
