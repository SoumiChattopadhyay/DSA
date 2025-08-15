import java.util.Arrays;
import java.util.Comparator;

public class StudentList implements Comparable<StudentList>{
    int rollno;
    float marks;
    public StudentList(int rollno,float marks){
        this.rollno=rollno;
        this.marks=marks;
    }
    //Overridding toString() called by println(). the toString() of Arrays doesnt get overridden coz its static
    @Override
    public String toString(){
        return this.rollno+" got "+this.marks;
    }
    @Override
    public int compareTo(StudentList o) {
        System.out.println("In compareTo method");
        int diff = (int)(this.marks-o.marks);
        return diff;
        
        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller
    }
    public static void main(String[] args) {
        StudentList s1 = new StudentList(1,95.38f );
        StudentList s2 = new StudentList(2,97.99f );
        StudentList s3 = new StudentList(3,94.67f);
        StudentList s4 = new StudentList(4,90.0f);
        StudentList s5 = new StudentList(5,91.23f);

        //array of objects
        StudentList[] arr = {s1,s2,s3,s4,s5};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);//this sort() funct also internally using our compareTo()
        System.out.println(Arrays.toString(arr));//so array els sorted according to marks(ascending order)

        //so if u didnt implement Comparable interface and wrote
        // Arrays.sort(arr);//you would have gotten error here as compiler couldn't sort objects. It would have confusion what u want me to compare these based on rollno or marks?

        //we can also provide an additional parameter to sort 
        Arrays.sort(arr,new Comparator<StudentList>() {
            public int compare(StudentList o1, StudentList o2){
                return o1.rollno-o2.rollno;
                //if diff>0 then swapping done
                //if diff<=0 then no swapping
            }
        });
        System.out.println(Arrays.toString(arr));
        
        //now doing it for marks
        Arrays.sort(arr,new Comparator<StudentList>() {
            public int compare(StudentList o1, StudentList o2){
                return (int)(o1.marks-o2.marks);
                //if diff>0 then swapping done
                //if diff<=0 then no swapping
            }
        });
        System.out.println(Arrays.toString(arr));

        //to get in descending order just add a minus sign('-')
        Arrays.sort(arr,new Comparator<StudentList>() {
            public int compare(StudentList o1, StudentList o2){
                return -(int)(o1.marks-o2.marks);
                //if diff>0 then swapping done
                //if diff<=0 then no swapping
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
// 1.Comparable
// Purpose: Defines the default or natural ordering of a class.
// How: Class implements Comparable<T> and overrides the compareTo() method.
// Where used: When you call Arrays.sort() or Collections.sort() without giving a Comparator.
// Limit: Only one natural ordering per class.(Either rollno or marks)

// 2. Comparator
// Purpose: Defines a custom ordering, separate from the class itself.
// How: Create a separate object (or lambda) that implements Comparator<T> and overrides compare().
// Where used: When you call Arrays.sort() or Collections.sort() and pass a Comparator as an argument.
// Advantage: You can have multiple different sorting rules without changing the class.