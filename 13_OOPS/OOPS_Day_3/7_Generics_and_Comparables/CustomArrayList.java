import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {
    private int[] data;//we want the user to not directly modify the arraylist but to only modify it through functions so private
    private static int DEFAULT_SIZE=10;
    private int size=0;//also working as an index value. size of custom arraylist is how many el.s u inserted in the data array not the length of the data array
    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }
    public void add(int num){
        if(this.isFull()){
            this.resize();
        }
        data[size++]=num;
    }
    private void resize() {
        int i=0;
        int[] temp = new int[data.length*2];
        //copy the current els. into the new array
        for(i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        size=i;
        data=temp;
    }
    public boolean isFull(){
        return size==data.length;
    }
    public int remove(){
        int removedItem = data[--size];
        return removedItem;
        //So we are not actually removing the item but reducing the instance var. size by one.
        //If we print the arraylist it will only go from 0 to size although the removedItem is still there in the list. It will later be overridden by the new item inserted.
    }
    public int get(int idx){
        return data[idx];
    }
    public int size(){
        return size;//Note:size=data.length only when array is full. data.length is otherwise not the actual size of our custom arraylist. size is
    }
    public void set(int idx,int num){
        data[idx]=num;
    }
    @Override
    public String toString() {
        return "CustomArrayList={"+"data="+Arrays.toString(data)+", size="+size+'}';
    }
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(3);
        list.add(5);
        list.add(9);
        // System.out.println();//the non-parameterized println() funct is called
        System.out.println(list);//the parameterized println(obj) funct is called
        
        //Problem:Internal ArrayList can store primitive and non-primitive data types. But here our custom arraylist can store only int values.
        //Internal ArrayList class uses Generics
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(9);
    }
    // ArrayList list = new ArrayList();//Raw use of parameterized class ArrayList. ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
    // list.add(2);    
    //🌺How does ArrayList work internally?
        //Ans: We keep adding els in it and when it gets full then a new arraylist which is double of its size is created and all the els alongwith the el. to be inserted is copied to the new arraylist 
        //resize(doubling) → copy elements → O(n)
        //But resize happens rarely, so over many insertions the average (amortized) time per insertion is still O(1)(It is called Amortized Constant Time Complexity.)
        //Doubling happens on a large scale at a time 10-->20-->40-->80... 
        //🌺ArrayList functions - add(val),remove(idx),get(idx),set(idx,val),size(),isEmpty(),isFull()

    //Why cant we use access modifiers for local variables inside a function?
    //1. Their Scope is already limited to the function.
    //2. Lifetime of a local variable is short
    //3.Access modifiers(public, private, protected) are for members of a class
    // Fields (instance variables)
    // Methods
    // Inner classes
    //They define who can access them from outside the class.
    // A local variable isn’t a class member — it’s just a temporary value in a method’s stack frame.

    //temp is the local var. so goes out of scope when function ends
    //data is the instance var. so goes out of scope when object is finished

    //println() is method of PrintStream class. 
    //valueOf() is method of String class
    //toString() is method of Object class

    // There are diff versions of these methods in their respective classes.Depending on the parameter list the required version is executed.

    //So the println(obj) calling valueOf(obj) which calls toString(obj)
    //So overriding toString(obj) method to print the arraylist

    

}
