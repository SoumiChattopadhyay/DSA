public class Prog20_largest_string {
    public static String Largest(String ar[]){
        String largest=ar[0];
        for(int i=1;i<ar.length;i++){
            if(ar[i].compareToIgnoreCase(largest)>0)
            largest=ar[i];
        }
        return largest;
    }
    public static void main(String[] args) {
        String ar[] = {"apple","mango","banana"};
        System.out.println(Largest(ar));
    }
}
