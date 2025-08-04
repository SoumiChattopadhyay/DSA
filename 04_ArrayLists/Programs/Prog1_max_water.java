import java.util.ArrayList;
public class Prog1_max_water{
    public static int findMaxWater(ArrayList<Integer> lines){
        int maxArea=Integer.MIN_VALUE;
        int height, width, line1, line2, area, lp, rp;
        //brute force - TC = O(n^2)
        // for(int i=0;i<lines.size();i++){
        //     for(int j=i+1;j<lines.size();j++){
        //         line1=lines.get(i);
        //         line2=lines.get(j);
        //         height=Math.min(line1,line2);
        //         width=Math.abs(j-i);
        //         area=height*width;
        //         maxArea=Math.max(area,maxArea);
        //     }
        // }

        // 2 pointer approach TC = O(n) because if lp moves d times then rp moves n-d times so total n times
        lp=0;
        rp=lines.size()-1;
        while(lp<rp){
            width=rp-lp;
            line1=lines.get(lp);//line which left pointer is pointing to
            line2=lines.get(rp);//line which right pointer is pointing to
            height=Math.min(line1,line2);
            area=height*width;

            if(line1<line2){//height of water depends on smaller line
                lp++;
            }else{
                rp--;
            }
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(8);
        list1.add(6);
        list1.add(2);
        list1.add(5);
        list1.add(4);
        list1.add(8);
        list1.add(3);
        list1.add(7);//ArrayList of heights of lines
        System.out.println(findMaxWater(list1));
    }
}