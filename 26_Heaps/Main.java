import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap= new Heap<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);
        // System.out.println(heap.list);//[22, 45, 34, 89, 76](make list in Heap.java public then do this)
        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);//[22, 34, 45, 76, 89]

        
        ArrayList<Integer>list2 = heap.createHeap(new Integer[]{4,1,3,2,16,9,10,14,8,7});
        System.out.println(list2);
    }
}
