// If you didn’t write package packageA; at the top of your file, then your class isn’t in any named package — it’s in the default package. Java does not allow you to import classes from the default package into a named package and from one default package into another. Only named-package to named-package access is allowed via import.
package Encapsulation_in_Detail_3;//open it's parent directory
public class A{
    //instance variables or data members
    private int num;//private means variable is accessible only in same class(i.e. this file)
    protected String name;//protected is used for inheritance. It means variable can be accessed in same class,same package,subclass of same package and subclass of different package.
    int[] arr;//default means variable can be accessed in same class,same package,subclass of same package but cannot be accesssed outside the package
    //constructor. //public means can be accessed in same class,same package,subclass of same package,subclass of different package and across different packages as well. we need to import this class there
    public A(int num, String name,int[]arr){
        this.num=num;
        this.name=name;
        this.arr=arr;
    }
    //getter 
    public int getNum(){
        return num;
    }
    public void getNum(int num){
       this.num=num;
    }
}