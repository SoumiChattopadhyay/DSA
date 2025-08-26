// You are given a 2D 0-indexed integer array dimensions.
// For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.
// Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.
class Solution {
    //TC=O(n), SC=O(1) {n is length of array}
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max=Integer.MIN_VALUE,maxArea=Integer.MIN_VALUE;
        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int diagSquare = l*l+w*w;//diag=sqrt(l*l+w*w)
            int area = l*w;
            if(diagSquare>max || (diagSquare==max && area>maxArea)){
                max=diagSquare;
                maxArea=area;
            }
        }
        return maxArea;
    }
}
/*Example:
 l=6,w=8
    Diagonal=6*6+8*8 = 100
    Area=6*8=48
 l=10,w=0
    Diagonal=10*10+0*0=100
    Area=10*0=0
So both rectangles have same diagonal but there areas differ
 */