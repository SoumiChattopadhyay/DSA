public class Prog3_Student{
    public static void main(String args[]){
        Student stu = new Student();
        stu.calPercent(98,99,100);
        System.out.println(stu.percentage);
        stu.maxMarks(78, 89, 86);
        System.out.println(stu.max);

        BankAccount myAcc = new BankAccount();
        myAcc.username="Soumi909";
        myAcc.setPassword("123456");//cannot access password but can change it
        System.out.println(myAcc.getPassword());
    }
}
class BankAccount{
    public String username;
    private String password;
    String getPassword() {
        return password;
    }
    public void setPassword(String pwd){
        password=pwd;
    }
}


class Student{
    float percentage;
    int max;
    void calPercent(int phy, int chem, int maths){
        percentage=(phy+chem+maths)/3;
    }
    void maxMarks(int phy, int chem, int maths){
        max=(phy>chem)?phy:chem;
        max=(max>maths)?max:maths;
    }
}

