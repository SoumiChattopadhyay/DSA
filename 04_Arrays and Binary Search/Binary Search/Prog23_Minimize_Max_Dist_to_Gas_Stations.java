public class Prog23_Minimize_Max_Dist_to_Gas_Stations {
    static double funct1(int[] arr, int k){
        int n=arr.length;
        int howMany[] = new int[n-1];//stores how many gas stations placed in each sector. We have k-1 sectors.
        for(int gasSt=1;gasSt<=k;gasSt++){
            double maxVal=-1;
            int maxInd=-1;
            for(int i=0;i<n-1;i++){//loop to figure out maxInd(sector with max dist(or sector which has a subsector which has the max dist out of all sectors and subsectors) In both cases we will store sector no. only, not subsectorn) and maxVal(dist of that sector)
                int diff=arr[i+1]-arr[i];
                int sectorLength = diff/(howMany[i]+1);
                if(maxVal<sectorLength){
                    maxVal=sectorLength;
                    maxInd=i;
                }
            }
            howMany[maxInd]++;//place the gas station in sector maxInd
        }
        double maxAns=-1;// loop to figure out the max dist of any sector or subsector
        for(int i=0;i<n-1;i++){
            int diff=arr[i+1]-arr[i];
            int sectorLength=diff/(howMany[i]+1);
            maxAns=Math.max(maxAns,sectorLength);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        int[] arr = {1,13,17,23};
        int k=5;
        System.out.println(funct1(arr, k));
    }
}
