public class Prog8_Water_Jug_Problem {
        public static boolean canMeasureWater(int x, int y, int target) {
            if(x+y<target){
                return false;
            }
            //find hcf using euclidean algo.
            while(y!=0){
                int temp=y;
                y=x%y;
                x=temp;
            }
            //if target%hcf==0 then true
            if(target%x==0){
                return true;
            }else{
                return false;
            }
        }
    public static void main(String[] args) {
       System.out.println( canMeasureWater(3, 5, 4));
       System.out.println( canMeasureWater(2, 4, 5));
       System.out.println( canMeasureWater(1, 1, 12));
    }
}
