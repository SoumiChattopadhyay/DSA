public class Square extends Shapes{
    double weight=2.0;
   // this will run when obj of Circle is created
    // hence it is overriding the parent method
    @Override // this is called annotation. In Circle and Triangle we didn't explicitly write this annotation but internally its there.
    void area(){
        System.out.println("Area is side*side");
    }
    static void greetings(){
        System.out.println("Hello from Square class.");
    }
}
