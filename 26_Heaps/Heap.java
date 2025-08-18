import java.util.ArrayList;
public class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int firstIdx, int secondIdx){
        T temp = list.get(firstIdx);
        list.set(firstIdx,list.get(secondIdx));
        list.set(secondIdx, temp);
    }
    private int parent(int idx){//returns parentIdx
        return (idx-1)/2;
    }
    private int left(int idx){//returns idx of left
        return 2*idx+1;
    }
    private int right(int idx){//returns idx of right
        return 2*idx+2;
    }
    public void insert(T val){
        list.add(val);//val added in list(now val is last el. of list, from val we will go upheap)
        upheap(list.size()-1);//send last idx to upheap
    }
    private void upheap(int idx){//upheap funct balances the heap after insertion
        if(idx==0){
            return;
        }
        int p = parent(idx);
        if(list.get(idx).compareTo(list.get(p)) < 0){
            swap(idx,p);
            upheap(p);//why keep this inside if not outside if, coz further upheap happens only if child<parent so we keep taking the child up until its parent is less than it or until the root node
        }
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }
        T remv = list.get(0);//suppose list had only 1 el. you get() it and store it in remv, then u remove() it and store it in last, so now if heap is empty means the heap had 1 el. only and it hase removed so do nothing and return the remv 
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }
        return remv;
    }
    private void downheap(int idx){
        int minIdx = idx;
        int leftIdx = left(idx);
        int rightIdx = right(idx);
        if(leftIdx<list.size()-1 && list.get(leftIdx).compareTo(list.get(rightIdx))<0){//if node has no left child then its leftIdx(2*idx+1) would be something greater than size of the list. likewise if node has no right child then its rightIdx(2*idx+2) would be something greater than size of the list. And since its a complete BT so all internal levels must be full except last level which is filled from left to right
            minIdx=leftIdx;
        }else if(rightIdx<list.size()-1 && list.get(rightIdx).compareTo(list.get(leftIdx))<0){//if we did till <list.size() problem would have been that the last if statement would run for idx=list.size() coz u are doing list.get(idx)=>list.get(list.size()) then u would have got IndexOutOfBoundsException. So if idx=list.idx()-1 then the 1st 2 ifs wont execute for it
            minIdx=rightIdx;
        }
        if(list.get(idx).compareTo(list.get(minIdx))>0){
            swap(idx,minIdx);
            downheap(minIdx);
        }
    }
    public ArrayList<T> heapSort()throws Exception{
        ArrayList<T> newList = new ArrayList<>();
        while(!list.isEmpty()){
            newList.add(this.remove());
        }
        return newList;
    }
    public ArrayList<T> createHeap(T[]arr){
        list.clear();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);//don't use list.set() it doesnt work on empty lists
        }
        for(int i=0;i<list.size();i++){
            downheap(i);
        }
        return list;
    }
}
