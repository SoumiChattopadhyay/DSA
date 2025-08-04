import java.util.*;

public class Prog2_maxActivities {
    public static void main(String[] args) {
        int start[]={0,1,3,5,5,8};//start time
        int[] end = {6,2,4,7,9,9};//end time(not sorted)
        ArrayList<Integer> ans = new ArrayList<>();
        int maxcount=0,selEnd;//selected activity's end time
        //step 1 : sort end time
        int arr[][]=new int[start.length][3];//We will take a 3D array which will have 3 cols
        for(int i=0;i<start.length;i++){
            arr[i][0]=i;//first col. will contain the index of each activity
            arr[i][1]=start[i];//second col. will contain the start time of that activity
            arr[i][2]=end[i];//third col. will contain the end time of that activity
        }
        Arrays.sort(arr,Comparator.comparingDouble(o->o[2]));
        //step 2 : select activity 1
        ans.add(arr[0][0]);
        maxcount++;
        selEnd=arr[0][2];
        // step 3 : start time of activity >= end time of previous selected activity then select it
        for(int i=1;i<start.length;i++){
            if(arr[i][1]>=selEnd){
                ans.add(arr[i][0]);
                maxcount++;
                selEnd=arr[i][2];
            }
        }
        System.out.println("Maximum activities that can be performed by a person = "+maxcount);
        System.out.print("Activities are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
