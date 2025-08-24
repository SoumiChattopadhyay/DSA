public class Prog1{
    public static void main(String[] args) {
        String name="Kunal";
        int code = name.hashCode();
        // System.out.println(code);//72858447

        Integer a = 4235678;
        code = a.hashCode();
        // System.out.println(code);//4235678

        code=Integer.hashCode(33);
        System.out.println(code);
        for(int i=1;i<=5;i++){
            System.out.println(code%5);
            code+=1;
        }
        // 33
        // 3
        // 4
        // 0
        // 1
        // 2
    }
}
