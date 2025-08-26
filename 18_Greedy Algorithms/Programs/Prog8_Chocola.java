import java.util.*;

public class Prog8_Chocola {
    public static void main(String[] args) {
        // int n=4,m=6;
        Integer costhor[]={4,1,2};
        Integer costver[]={2,1,3,1,4};
        int hp=1,vp=1;
        int h=0,v=0;
        int minCost=0;
        // ArrayList<Integer>ans=new ArrayList<>();
        Arrays.sort(costhor,Collections.reverseOrder(null));
        Arrays.sort(costver,Collections.reverseOrder(null));
        while(h<costhor.length && v<costver.length){
            if(costhor[h]<=costver[v]){//vertical cut
                minCost+=(costver[v]*hp);
                vp++;
                v++;
            }else{//horizontal cut
                minCost+=(costhor[h]*vp);
                hp++;
                h++;
            }
        }
        while(h<costhor.length){
            minCost+=(costhor[h]*vp);
            hp++;
            h++;
        }
        while(v<costver.length){
            minCost+=(costver[v]*hp);
            vp++;
            v++;
        }
        System.out.println("min cost = "+minCost);
        System.out.println("no. of horizontal and vertical pieces are "+hp+" and "+vp);
    }
}
