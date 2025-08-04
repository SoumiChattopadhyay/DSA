// Inner loop must start from i+1
import java.util.*;
public class Prog31_Assignment{
    public static void main(String args[]){
        int ar[] = new int[4];
        boolean duplicateFound=false;
        System.out.println("Enter the elements of the array:");
        Scanner sc = new Scanner(System.in);
        for(int k=0;k<4;k++){
            ar[k]=sc.nextInt();
        }
        sc.close();
        // for(int i=0; i<4;i++){
        //     for(int j=1;j<4;j++){ In inner loop element is comparing with itself from 2nd iteration of i loop
        for(int i=0; i<4;i++){
            for(int j=i+1;j<4;j++){
                if(ar[i]==ar[j]){
                    duplicateFound=true;
                    break;
                }
            }
        }
        if(!duplicateFound)
        System.out.println(false);
        else
        System.out.println(true);
    }
}