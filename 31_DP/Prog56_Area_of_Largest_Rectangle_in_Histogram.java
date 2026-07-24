import java.util.Stack;

public class Prog56_Area_of_Largest_Rectangle_in_Histogram {
    // Best Solution (O(n)) - One Pass Solution
    static int findLargestArea(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width=i;//stack is empty means ls doesnt exist So width = rS only, not rS-lS-1   (rS=i)
                }
                else{
                    width=i-st.peek()-1;//rS-lS-1 (rS=i, lS=st.peek())
                }
                maxArea=Math.max(maxArea,width*height);
            }
            st.push(i);
        }
        return maxArea;
    }

    // Optimal Solution (O(n)) - Two Pass Solution
    static int findLargestArea2(int[] heights){
        int n = heights.length;
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Loop to find left boundary for each block height
        for(int i=0;i<n;i++){
            // first clear all the left nges.(next greater els.) from stack
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            // if stack is empty, left boundary is 0, else left boundary is left nse(next smaller el.) idx + 1 (In the stack the next smaller els. remain as we have already remove next greater and next equal els.)
            if(st.isEmpty()) leftBoundary[i]=0;
            else leftBoundary[i]=st.peek()+1;
            // push current index onto stack
            st.push(i);
        }

        // Clear the stack to re-use it
        while(!st.isEmpty()){
            st.pop();
        }

        // Loop to find right boundary for each block height
        for(int i=n-1;i>=0;i--){
            // first clear all the right nges.(next greater els.) from stack
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            // if stack is empty, right boundary is n-1, else right boundary is right nse(next smaller el.) idx - 1 (In the stack the next smaller els. remain as we have already remove next greater and next equal els.)
            if(st.isEmpty()) rightBoundary[i]=n-1;
            else rightBoundary[i]=st.peek()-1;
            // push current index onto stack
            st.push(i);
            // Line 45 can be written here to remove another set of N iterations
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,(rightBoundary[i]-leftBoundary[i]+1)*heights[i]);
        }

        return maxArea;
    }
    // Brute Force(O(n²))
    static int findLargestArea3(int[] heights){
        int n = heights.length;
        int leftSmaller,rightSmaller;// stores idx of left smaller el, stores idx of right smaller el
        int maxArea=0;
        for(int i=0;i<n;i++){
            leftSmaller=i;
            rightSmaller=i;
            while(leftSmaller>=0 && heights[leftSmaller]>=heights[i]){
                leftSmaller--;
            }
            int leftBoundary=leftSmaller+1;//stores the idx next to leftSmaller 
            
            while(rightSmaller<=n-1 && heights[rightSmaller]>=heights[i]){
                rightSmaller++;
            }
            int rightBoundary =rightSmaller-1;//stores the idx previous to rightSmaller 

            // Once we have the left boundary and right boundary we evaluate width and area
            int area = (rightBoundary-leftBoundary+1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3,1};
        System.out.println(findLargestArea3(heights));
        System.out.println(findLargestArea2(heights));
        System.out.println(findLargestArea(heights));
    }
}