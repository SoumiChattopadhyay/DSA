package Encapsulation_in_Detail_3;//open it's parent directory
public class SubClass extends A{
    public SubClass(int num,String name,int arr[]){
        super(num,name,arr);
    }
    public static void main(String[] args) {
        SubClass obj = new SubClass(6, "Mistu", new int[6]);
        System.out.println(obj.getNum());
        // System.out.println(obj.num);//wrong
        System.out.println(obj.arr);
        System.out.println(obj.name);
    }
}
