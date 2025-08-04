public class Prog4_diff_const {
    public static void main(String args[]){

        Student s1 = new Student();//Non-parameterized constructor is called and its print statement is executed
        Student s2 = new Student("Soumi");//Parameterized constructor is called (The name property of object is not same as that of the class)
        Student s3 = new Student(211);

        System.out.println(s1.name+" "+s1.roll+" "+s1.password+" ");//Lady Cat 1000 cat
        System.out.println(s2.name+" "+s2.roll+" "+s2.password+" ");//Soumi 1000 cat
        System.out.println(s3.name+" "+s3.roll+" "+s3.password+" ");//Lady Cat 211 cat
        
    }
}
class Student{
    String name="Lady Cat";
    int roll=1000;
    String password="cat";
    // int marks[];//Declared
    // marks=new int[3];//Why is this incorrect?
    // int marks[]=new int[3];//Initialized
    

    //Non-Parameterized Constructor
    Student(){
        System.out.println("Constructor is called...");
    }

    //Parameterized Constructor
    Student(int roll){
        this.roll=roll;
    }
    Student(String name){
        this.name=name;
    }

}