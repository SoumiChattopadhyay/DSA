public class Generic_Main implements Generic_Interface<Integer>{//mention the value of type parameter here 
    @Override
    public void display(Integer num){//must make this method public as abstract methods are public in the interface
        System.out.println(num);
    }
    public static void main(String[] args) {
        Generic_Main obj = new Generic_Main();
        // obj.display(60.9);//error
        obj.display(60);
    }
}
