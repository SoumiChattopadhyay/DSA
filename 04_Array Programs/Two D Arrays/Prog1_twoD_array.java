import java.util.*;
public class Prog1_twoD_array{
    public static boolean Search(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println(key+" exists at index ("+i+","+j+")");
                return true;
            }
        }
    }
    return false;
    }
    public static void printMatrix(int[][]matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int matrix[][]=new int[3][4];
        int n=matrix.length;//no. of rows
        int m=matrix[0].length;//no. of cols
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        printMatrix(matrix);
        System.out.println("Enter element to be searched:");
        int ele=sc.nextInt();
        boolean b= Search(matrix,ele);
        if(b==false){
        System.out.println("Element does not exist in the matrix.");
        }
        sc.close();
}
}