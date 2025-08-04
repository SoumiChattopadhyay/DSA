class Prog8_Method_Overloading{
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.Sum(2,3));
        System.out.println(cal.Sum((float)4.0,(float)3.0));
        System.out.println(cal.Sum(4,5,6));
    }
}
class Calculator{
    int Sum(int a, int b){
        return a+b;
    }
    float Sum(float a, float b){
        return a+b;
    }
    int Sum(int a, int b, int c){
        return a+b+c;
    }
}