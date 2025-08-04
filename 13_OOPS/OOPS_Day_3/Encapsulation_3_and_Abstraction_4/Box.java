//Encapsulation(putting all code in a bundle. some data is hidden by data hiding and getters and setters)
// Encapsulation is process of containing and securing information from outside world.
// In Data hiding, data is made private & cannot be accessed directly, getters and setters are needed to access data
public class Box {
    private double l=9.0;//Data hiding(process of making things private)
    double h=5.0;
    double w=4.0;
    //using default values instead of constructor-initialised-values 
    
    //getter method.
    double getL(){
        return l;//l is accessible in this file not outside this file, but this method is accessible outside this file so we can use this method to get the value of l outside this file. Hence it's called getter method as it's used to get the value of l.
    }
}
