public class BoxPrice extends BoxWeight{
    double price;
    BoxPrice(){
        // super();// Even if we dont call the superclass constructor compiler will do it automatically but only the default constructor of superclass will be called everytime so if we want the parameterized ones to get called we need to explicitly call them
        System.out.println("In BoxPrice constructor 1");
        this.price=-1;
    }
    BoxPrice(double side,double weight,double price){
        super(side,weight);
        System.out.println("In BoxPrice constructor 2");
        this.price=price;
    }
    BoxPrice(double l,double h,double w,double weight,double price){
        super(l,h,w,weight);
        System.out.println("In BoxPrice constructor 3");
        this.price=price;
    }
    BoxPrice(BoxPrice old){
        super(old);//BoxWeight has BoxWeight type ref. var as argument that accepts this object address of type BoxPrice and sends it to Box constructor which has ref var of type box as argument so it initialises the l,h,w vars first then control goes to BoxWeight constructor which initialises the weight and then control comes here where price var is initialized.
        System.out.println("In BoxPrice constructor 4");
        
        this.price=old.price;
    }
}
