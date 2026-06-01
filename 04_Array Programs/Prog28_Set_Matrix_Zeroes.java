import java.util.Arrays;

public class Prog28_Set_Matrix_Zeroes {
    // Brute(works only for binary array)
    static int[][] funct1(int[][] arr){
        int n = arr.length;
        int m  = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){//then change only the 1s in row i and in col j  to -1s
                    for(int c=0;c<m;c++){//O(m)
                        if(arr[i][c]!=0)
                            arr[i][c]=-1;
                    }
                    for(int r=0;r<n;r++){//O(n)
                        if(arr[r][j]!=0)
                            arr[r][j]=-1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==-1)
                    arr[i][j]=0;
            }
        }
        return arr;
    }
    //Brute(works for all types of array)
    static int[][] funct1_2(int[][] arr){
        int n = arr.length;
        int m  = arr[0].length;
        
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=arr[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    for(int c=0;c<m;c++){//O(m)
                        if(arr[i][c]!=0)
                            ans[i][c]=0;
                    }
                    for(int r=0;r<n;r++){//O(n)
                        if(arr[r][j]!=0)
                            ans[r][j]=0;
                    }
                }
            }
        }
        
        return ans;
    }
    // Better
    static int[][] funct2(int[][] arr){
        int n = arr.length;
        int m  = arr[0].length;
        int[] rowTrack = new int[n];
        int[] colTrack = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){//then mark that row & col for conversion 
                    rowTrack[i]=1;
                    colTrack[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rowTrack[i]==1 || colTrack[j]==1){
                    arr[i][j]=0;
                }
            }
        }
        return arr;
    }
    // Optimal
    static int[][] funct3(int[][] arr){
        int n = arr.length;
        int m  = arr[0].length;

        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    if(j==0)
                        col0=0;
                    else
                        arr[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){//we dont need arr[0][0] or col0 variable as we will convert first row and first col later
                if(arr[i][j]!=0){
                    if(arr[0][j]==0 || arr[i][0]==0){
                        arr[i][j]=0;
                    }
                }
            }
        }
        if(arr[0][0]==0){
            for(int j=1;j<m;j++){
                arr[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                arr[i][0]=0;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        int[][] ans = funct1(arr);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();


        arr = new int[][]{
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        ans = funct2(arr);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();


        arr = new int[][]{
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        ans = funct3(arr);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();


        arr = new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        ans = funct1_2(arr);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
    }
}
