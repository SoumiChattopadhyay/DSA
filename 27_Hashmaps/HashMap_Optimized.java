import java.util.ArrayList;
import java.util.LinkedList;
//Using Chaining(Linked list)
public class HashMap_Optimized<K,V>{
    //instance variables
    private ArrayList<LinkedList<Entity>> arrlist;
    private int size=0;// size here means n(no.of els inserted in the arraylist)
    private float lf=0.5f;//total items inserted / total size of the array.Load factor is 0.5 means If u already added 50 items in an array of size 100 then when u will attempt to add the 51st item then the size will double from 100 to 200, all 50 els will be copied to the new array and then the 51st el will be added. It takes Amortized constant time. 
    //Constructor
    public HashMap_Optimized(){
        arrlist = new ArrayList<>();
        for(int i=0;i<10;i++){
            arrlist.add(new LinkedList<>());//empty linked lists are added in the arraylist
        }
        // System.out.println(arrlist);//[[], [], [], [], [], [], [], [], [], []]
    }
    public V put(K key, V value){
        int hash = Math.abs(key.hashCode()%arrlist.size());//initially arrlistsize(m)=10 then 20 then 40.....
        LinkedList<Entity> ll = arrlist.get(hash);//it wud either be an empty ll or an actual ll
        for(Entity entity:ll){
            if(entity.key==key){
                V oldVal = entity.value;
                entity.value=value;
                return oldVal;
            }
        }
        if((float)size/arrlist.size()>lf){
            rehash();
        }
        ll.add(new Entity(key, value));
        size++;
        return null;
    }
    private void rehash(){
        System.out.println("We are rehashing now!");
        ArrayList<LinkedList<Entity>> old = arrlist;
        arrlist=new ArrayList<>();
        size=0;
        for(int i=0;i<old.size()*2;i++){
            arrlist.add(new LinkedList<>());
        }
        for(LinkedList<Entity> ll:old){
            for(Entity entity:ll){
                put(entity.key,entity.value);
            }
        }
    }
    public V remove(K key){
        int hash = Math.abs(key.hashCode()%arrlist.size());
        LinkedList<Entity> ll = arrlist.get(hash);
        Entity target=null;
        for(Entity entity:ll){
            if(entity.key.equals(key)){
                target=entity;
                ll.remove(target);
                return target.value;
            }
        }
        return null;        
    }
    public V get(K key) {
        int hash = Math.abs(key.hashCode() % arrlist.size());
        LinkedList<Entity> ll = arrlist.get(hash);
        for(Entity entity : ll) {
            if(entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
        builder.append("{");
      for(LinkedList<Entity> ll : arrlist) {
        for(Entity entity : ll) {
          builder.append(entity.key);
          builder.append(" = ");
          builder.append(entity.value);
          builder.append(" , ");
        }
      }
      builder.append("}");

      return builder.toString();
    }
    //Inner class
    private class Entity{// In Java, only nested (inner) classes can be declared private. Top-level classes (those not defined inside another class) can only be public or package-private (no modifier).
        K key;
        V value;

        public Entity(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        HashMap_Optimized<String,String> map = new HashMap_Optimized<>();
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Kunal's fav fruit");

        System.out.println(map);
    }
}
/*
Initially arrlist filled with 10 empty lls. So m=10.
Algorithm for put(key,val) funct:
1. hash for key is found which is within the range(0-m). m is size of arrlist
2. Then ll present in the arrlist at idx=hash is taken
3. And for each entity in the ll, key is checked with entity.key
   if(key.equals(entity.key)) then entity.value is updated to value(Updation operation)
4. But if No updation happens means entity with that key doesnt exist in the entire ll
   then it is an Insertion operation
5. So before inserting the entity in the ll, first check if n/m is >than load-factor or not
   if so then u need to double the size of arraylist and fill it fully with empty lls and again create a new entity based on the old entity's key and value
   and store that entity in the ll and store the ll in arrlist at idx=hash(now hash is within range 0-doubled size of arrlist)
   then after inserting all the entities in the initially empty linkedlists like this we finally 
   insert the new entity

   then at the end we create and add a new entity with that key and value to the ll(Insertion operation)
 */