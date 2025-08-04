public class Prog18_strings_shortest_path {
    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0; i<path.length();i++){
            if(path.charAt(i)=='N'){
                y++;
            }
            else if(path.charAt(i)=='S'){
                y--;
            }
            else if(path.charAt(i)=='E'){
                x++;
            }
            else{
                x--;
            }
        }//Time complexity depends on the no. of characters in the string
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);//we could have used int but float is preferred to get the entire shortest distance
    }
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(getShortestPath(str));
    }
}
