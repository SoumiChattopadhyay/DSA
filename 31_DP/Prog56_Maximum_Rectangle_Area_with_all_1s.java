import java.util.Stack;

public class Prog56_Maximum_Rectangle_Area_with_all_1s {
    static int findLargestArea(int[] heights){
        int n=heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width=i;//width is only rS
                else width=i-st.peek()-1;//width is rS-lS-1
                maxArea=Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
    static int maximalRectangle(char[][] matrix){
        int n=matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){//if 1 appears add 1 to previous heights
                    heights[j]+=1;
                }
                else{//reset height to 0 when 0 appears then previous heights not considered anymore
                    heights[j]=0;
                }
            }
            maxArea=Math.max(maxArea,findLargestArea(heights));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Area of maximal rectangle = "+maximalRectangle(matrix));
    }
}


/*
The Issue : heights[j] += (int)matrix[i][j];
matrix[i][j] is a char ('0' or '1'), so casting it to int gives ASCII values:

'0' → 48
'1' → 49

So instead of building heights like 0,1,2..., you're building something like 49, 98, 147... 

Fix: You need to treat '1' as 1 and '0' as 0, and also reset height when it's '0'. */