public class Prog13_xor_from_0_to_a {
    public static int find(int a){
        // if(a%4==0){
        //     return a;
        // }else if(a%4==1){
        //     return 1;
        // }else if(a%4==2){
        //     return a+1;
        // }else{
        //     return 0;
        // }
        return (a%4==0)?a:(a%4==1)?1:(a%4==2)?a+1:0; //TC=O(1), SC=O(1)
    }
    public static void main(String[] args) {
        System.out.println(find(4));
    }
}
