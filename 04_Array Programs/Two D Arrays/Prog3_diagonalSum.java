public class Prog3_diagonalSum {
    public static void findDiagonalSum(int matrix[][]){//rows=columns always to find diagonal sum
        int sum=0;
        int n=matrix.length;
        //Brute Force TC=O(n^2)
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }else if(i+j==matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
        // }
        // TC=O(n)
        for(int i=0;i<n;i++){
            //Primary Diaginal Sum
            sum+=matrix[i][i];
            //Secondary Diagonal Sum
            if(i!=n-1-i){//avoids duplicate printing of intersection ele
                sum+=matrix[i][n-1-i];//since i+j=n-1 then secpndary diagonal. So j=n-1-i
            }
        }
        System.out.println("Sum = "+sum);
    }
    public static void main(String[] args) {
        int matrix[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};
            findDiagonalSum(matrix);
    }
}
