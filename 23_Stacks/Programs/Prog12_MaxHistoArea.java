import java.util.Stack;
public class Prog12_MaxHistoArea {
    public static int findMaxArea(int heights[]) {//nextSmaller in both sides will be like boundary
        Stack<Integer> s = new Stack<>();//used to find next smaller right and next smaller left
        int maxArea=0;
        int nextL[]=new int[heights.length];
        int nextR[]=new int[heights.length];
        //find next smaller right
        for(int i=heights.length-1;i>=0;i--){
            int currHeight=heights[i];
            while(!s.isEmpty()&& heights[s.peek()]>=currHeight){
                s.pop();
            }
            if(s.isEmpty()){
                nextR[i]=heights.length;
            }else{
                nextR[i]=s.peek();
            }
            s.push(i);
        }
        //find next smaller left
        for(int i=0;i<heights.length;i++){
            int currHeight=heights[i];
            while(!s.isEmpty()&& heights[s.peek()]>=currHeight){
                s.pop();
            }
            if(s.isEmpty()){
                nextL[i]=-1;
            }else{
                nextL[i]=s.peek();
            }
            s.push(i);
        }
        //Current area: area=height*width = heights[i]*(j-i-1) let j=nextR[i], i=nextL[i]
        for(int k=0;k<heights.length;k++){
            int j=nextR[k];
            int i=nextL[k];
            int width=j-i-1;
            int area=heights[k]*width;
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};//heights in histogram
       System.out.println("Max area in histogram = "+findMaxArea(heights));
    }
}
