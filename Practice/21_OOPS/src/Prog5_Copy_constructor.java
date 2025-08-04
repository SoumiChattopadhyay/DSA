public class Prog5_Copy_constructor {
    public static void main(String[] args) {
    
    Student s1 = new Student();
        s1.name="Soumi";
        s1.roll=211;
        s1.password="abcd";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s2 = new Student(s1);
        s2.password="xyz";
        s1.marks[2]=100;
        
        for(int i=0;i<3;i++){//Printing the values of s2 after copying it from s1
            System.out.println(s2.marks[i]);
        }
        
}
}
class Student{
    String name;
    int roll;
    String password;
    int marks[];
    Student(){
        marks=new int[3];
        System.out.println("Non-Parameterized Constructor is called...");
    }

    //shallow copy constructor(reference copied)
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }

    //deep copy constructor(whole array copied)
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }
}