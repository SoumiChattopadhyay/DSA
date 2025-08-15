public interface Generic_Interface<T>{
    void display(T num);

    
    
    
    //OK. then its providing default implementation
    default void hello(){
        System.out.println("Hello");
    }  
    //Error: Abstract methods do not specify a body
    // void hello(){
    //     System.out.println("Hello");
    // }      
} 