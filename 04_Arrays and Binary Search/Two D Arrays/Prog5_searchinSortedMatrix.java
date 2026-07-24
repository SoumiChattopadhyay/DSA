import java.util.Arrays;
public class Prog5_searchinSortedMatrix {
    static int[] binarySearch(int [][]ar, int target,int rowNo,int startCol,int endCol){
        while(startCol<=endCol){
            int mid=startCol+(endCol-startCol)/2;
            if(ar[rowNo][mid]==target){
                return new int[]{rowNo,mid};
            }
            else if(ar[rowNo][mid]<target){
                startCol=mid+1;
            }
            else{
                endCol=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int ar[][],int target){
        int rows=ar.length;
        int cols = ar[0].length;
        if(cols==0){
            return new int[]{-1,-1};
        }
        //Edge case : matrix has only 1 row
        if(rows==1){
            return binarySearch(ar,target,0,0,cols-1);
        }
        int midCol=cols/2;
        int startRow=0,endRow=rows-1;
        
        while(startRow<endRow-1){//run the loop till 2 rows are remaining //while(endRow!=startRow+1) or while(endRow-1!=startRow)
        int mid = startRow+(endRow-startRow)/2;//middle row which is also the middle element row position
        if(ar[mid][midCol]==target){
            return new int[]{mid,midCol};
        }
        else if(ar[mid][midCol]>target){
            endRow=mid;
        }
        else{
            startRow=mid;
        }
    }
        //now we have 2 rows
        //check if target is in midcol
        if(target==ar[startRow][midCol])
            return new int[]{startRow,midCol};
        if(target==ar[startRow+1][midCol])
            return new int[]{startRow+1,midCol};

        //cross check other rows
        //search in first half
        if(target<=ar[startRow][midCol-1]&&target>=ar[startRow][0])
            return binarySearch(ar, target, startRow, 0, midCol-1);
        //search in second half
        if(target>=ar[startRow][midCol+1]&& target<=ar[startRow][cols-1])
            return binarySearch(ar, target, startRow, midCol+1, cols-1);
        //search in third half
        if(target<=ar[startRow+1][midCol-1]&&target>=ar[startRow+1][0])
            return binarySearch(ar, target, startRow+1, 0, midCol-1);
        //search in fourth half
        // if(target>=ar[startRow+1][midCol+1]&& target<=ar[startRow+1][cols-1])
        else
            return binarySearch(ar, target, startRow+1, midCol+1, cols-1);
      } 
    public static void main(String[] args) {
        int matrix[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int target=3;
        System.out.println(Arrays.toString(search(matrix,target)));
    }
}
