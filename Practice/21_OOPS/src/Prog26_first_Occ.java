//TC :O(n)
//SC: O(n+n)=O(n)
public class Prog26_first_Occ {
    public static int findOcc(int ar[],int key,int i){
        if(i==ar.length-1 && ar[i]!=key)
            return -1;
        else{
            if(ar[i]==key)
               return i;
            return findOcc(ar,key,i+1);
        }
    }
    public static void main(String[] args) {
        int key=9;
        int ar[]={1,5,8,3,9};
        System.out.println(findOcc(ar,key,0));
    }
}
