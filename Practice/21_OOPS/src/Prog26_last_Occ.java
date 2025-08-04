public class Prog26_last_Occ {
    public static int findOcc(int ar[], int key, int i){
        if(i==0 && ar[i]!=key)
            return -1;
        else{
            if(ar[i]==key)
               return i;
            return findOcc(ar,key,i-1);
        }
    }
    public static void main(String[] args) {
        int key=8;
        int ar[]={8,9,3,5,8,9,3,9};
        System.out.println(findOcc(ar,key,ar.length-1));
    }
}
