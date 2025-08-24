public class HashMap{
    private Entity[] entities;//array of entities(entity is a user-defined Java object containing key and value as instance variables)
    public HashMap(){
        entities = new Entity[100];
    }
    //put() returns the old value associated with the key (if there was one).
    public String put(String key, String value){
        int hash = Math.abs(key.hashCode()%entities.length);
        String oldVal = entities[hash].value;
        entities[hash]= new Entity(key, value);//overriding can happen
        return oldVal;
    }
    public String remove(String key){
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key==key){
            String r = entities[hash].value;
            entities[hash]=null;
            return r;
        }
        return null;        
    }
    public String get(String key){
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key==key){
            return entities[hash].value;
        }
        return null;        
    }
    //Inner class
    private class Entity{// In Java, only nested (inner) classes can be declared private. Top-level classes (those not defined inside another class) can only be public or package-private (no modifier).
        String key;
        String value;

        public Entity(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Mango","King of Fruits");
        map.put("Apple","Sweet Red Fruit");
        map.put("Guava","Healthy Green Fruit");
        map.put("Banana","Healthy Yellow Fruit");
        System.out.println(map.get("Apple"));
        map.remove("Banana");
    }
}