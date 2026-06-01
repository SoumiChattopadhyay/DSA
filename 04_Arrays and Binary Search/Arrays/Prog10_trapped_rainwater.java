//Total time complexity is proportional to no. of bars
//O(n)-->Linear time complexity most optimum way to run a code
public class Prog10_trapped_rainwater {
    public static int trappedRainwater(int[]h,int w){
        int trappedWater=0;
        int n=h.length;
        //creating leftmax boundary array and rightmax boundary array
        int left[]=new int[n];
        int right[]=new int[n];
        //calculating leftmax boundary array and rightmax boundary array
        left[0]=h[0];
        right[n-1]=h[n-1];
        for(int i=1;i<n;i++){
            left[i]=Math.max(h[i],left[i-1]);
            right[n-1-i]=Math.max(h[n-1-i],right[n-1-i+1]);
        }
        //finding water level and trapped water
        for(int i=0;i<n;i++){
            int waterLevel = Math.min(left[i],right[i]);//water level = min(leftmax boundary,rightmax boundary)
            trappedWater += (waterLevel-h[i])*w;//trapped water = (water level-height of bar)*width of bar;
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        int width=1;
        int tw = trappedRainwater(height,width);
        System.out.println("Area of total trapped rainwater = "+tw);
    }
}