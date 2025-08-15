//Comparable is an interface with Generic type. Our class implements it. So it has to also implement all the unimplemented abstract methods(compareTo)
public class Student implements Comparable<Student>{//type parameter is Student coz we wanna compare two Student type objects kunal and rahul
    int rollno;
    float marks;
    public Student(int rollno,float marks){
        this.rollno=rollno;
        this.marks=marks;
    }
    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks-o.marks);
        return diff;
        
        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller
    }
    public static void main(String[] args) {
        Student kunal = new Student(11, 89.76f);
        Student rahul = new Student(5, 99.52f);

        if(kunal.compareTo(rahul)<0){
            System.out.println(kunal.compareTo(rahul));//-9
            System.out.println("Rahul has more marks.");
        }else if(kunal.compareTo(rahul)==0){
            System.out.println("Both have same marks.");
        }else{
            System.out.println("Kunal has more marks.");
        }

        
    }
    
}
