public class Prog15_use_of_static {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName="A.G.Church,Asansol";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName="BRS";
        System.out.println(s2.schoolName);

        System.out.println(s1.returnPercentage(88,99,95));
    }
}

class Student{
    String name;
    int roll;
    static String schoolName;

    static int returnPercentage(int phy, int math, int chem){
        return (phy+chem+math)/3;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
}