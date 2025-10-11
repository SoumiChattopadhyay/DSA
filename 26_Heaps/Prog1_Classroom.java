import java.util.Comparator;
import java.util.PriorityQueue;

public class Prog1_Classroom {
    static class Student implements Comparable<Student>{//Comparable interface allows the classes implementing it to compare their objects
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){//Student class must implement the incomplete method of Comparable interface
            return this.rank-s2.rank;
        }
        //compareTo method returns one of the 3 values : -1, 0, or 1
        //-1 -> 'this' is less than 'obj2'
        //0 -> 'this' is equal to 'obj2'
        //1 -> 'this' is greater than 'obj2'
    }
    public static void main(String[] args) {
        //PriorityQueue is an in-built class in Java
        //If it stores integers then by default small integer has more priority
        //So if we peek - smallest integer will be at the top of it
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(3);
        System.out.println(pq.peek());//1
        //So elements come out from PQ in ascending order
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");//1 2 3
            pq.remove();
        }
        System.out.println();


        //To reverse the priority from smallest integer to largest integer
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(1);
        pq.add(3);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");//3 2 1
            pq.remove();
        }
        System.out.println();



        //To allow Student class to compare its objects we use Comparable interface
        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student("Soumi",2));
        pq2.add(new Student("Avirup",1));
        pq2.add(new Student("Ravi",3));
        //if inner Student class was not static
        //Prog1_Classroom prog = new Prog1_Classroom();
        //pq2.add(prog.new Student("Avirup", 2));
        while(!pq2.isEmpty()){
            System.out.println(pq2.peek().name+"-->"+pq2.peek().rank);
            pq2.remove();
        }
    }
}
