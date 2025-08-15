import java.util.Arrays;
//Object type is the biggest type. So we can make the data array as Object type
public class CustomGenArrayList<T> {
    //Instance variable data which is array of objects
    private Object[] data;//we want the user to not directly modify the arraylist but to only modify it through functions so private
    private static int DEFAULT_SIZE=10;
    private int size=0;//also working as an index value. size of custom arraylist is how many el.s u inserted in the data array not the length of the data array
    public CustomGenArrayList(){
        // this.data = new T[DEFAULT_SIZE];//if we made data T type and did this then compile-error
        this.data = new Object[DEFAULT_SIZE];
    }
    public void add(T num){
        if(this.isFull()){
            this.resize();
        }
        data[size++]=num;//If type parameter is Integer then Integer values stored in the Object[](array of objects) if some other type given anywhere in the code then compiler error and if type parameter is String then String values stored in the Object[](array of objects) if some other type given then compile error
    }
    private void resize() {
        int i=0;
        Object[] temp = new Object[data.length*2];
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
    public T remove(){
        T removedItem = (T)(data[--size]);//in variable of smaller type(Integer in this case) u cant a value of bigger type(Object type). So cast it to T.
        return removedItem;
        //So we are not actually removing the item but reducing the instance var. size by one.
        //If we print the arraylist it will only go from 0 to size although the removedItem is still there in the list. It will later be overridden by the new item inserted.
    }
    public T get(int idx){
        return (T)data[idx];
    }
    public int size(){
        return size;//Note:size=data.length only when array is full. data.length is otherwise not the actual size of our custom arraylist. size is
    }
    public void set(int idx,T num){
        data[idx]=num;
    }
    @Override
    public String toString() {
        return "CustomArrayList={"+"data="+Arrays.toString(data)+", size="+size+'}';
    }
    public static void main(String[] args) {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        list.add(3);
        list.add(5);
        list.add(9);
        // list.add("9");//compile-time error
        System.out.println(list);

        CustomGenArrayList<String> list2 = new CustomGenArrayList<>();
        list2.add("hello");
        list2.add("hi");
        list2.add("bye");
        // list.add(9);//compile-time error
        System.out.println(list2);
    }
}
