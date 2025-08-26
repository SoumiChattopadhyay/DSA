import java.util.ArrayList;
public class Prog1_maxActivities{
    public static void main(String[] args){
        int start[]={1,3,0,5,8,5};//start time
        int[] end = {2,4,6,7,9,9};//end time(sorted)
        ArrayList<Integer> ans = new ArrayList<>();
        int maxcount=0,selEnd=0;//selected activity's end time
        //step 1 : select activity 1
        ans.add(0);
        maxcount++;
        selEnd=end[0];
        // step 2 : start time of activity >= end time of previous selected activity then select it
        for(int i=1;i<start.length;i++){
            if(start[i]>=selEnd){
                ans.add(i);
                maxcount++;
                selEnd=end[i];
            }
        }
        System.out.println("Maximum activities that can be performed by a person = "+maxcount);
        System.out.print("Activities are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}