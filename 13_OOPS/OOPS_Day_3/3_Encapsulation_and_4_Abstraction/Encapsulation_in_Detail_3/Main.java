package Encapsulation_in_Detail_3;//open it's parent directory
public class Main {
    public static void main(String[] args) {//that's why main is public, so that it can be accessed from anywhere
        A obj = new A(9,"Soumi",new int[9]);
        System.out.println(obj.getNum());
        // System.out.println(obj.num);//wrong
        System.out.println(obj.name);
        System.out.println(obj.arr);
    }
   
}
