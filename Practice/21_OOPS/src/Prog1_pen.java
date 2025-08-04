public class Prog1_pen {
    public static void main(String args[]){
        Pen p1=new Pen();
        p1.setColor("blue");
        System.out.println(p1.getColor());

        Pen p2 = new Pen();
        System.out.println(p2.getColor());
    }
}
class Pen{
    String color;
    int tip;

    //Setters
    void setColor(String color){
        this.color = color;
    }
    void setTip(int tip){
        this.tip = tip;
    }


    //Getters
    String getColor(){
        return color;
    }
    int getTip(){
        return tip;
    }

}

