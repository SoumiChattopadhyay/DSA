import java.util.Scanner;
public class Prog1_Binary_Tree_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Prog1_Binary_Tree tree = new Prog1_Binary_Tree();
        tree.populate(sc);
        // tree.display();
        tree.prettyDisplay();
    }
}
// Enter the value:
// 15
// Do you want to enter the left of 15?
// true
// Enter the value of the left of 15
// 8
// Do you want to enter the left of 8?
// true
// Enter the value of the left of 8
// 7
// Do you want to enter the left of 7?
// false
// Do you want to enter the right of 7?
// false
// Do you want to enter the right of 8?
// true
// Enter the value of the right of 8
// 9
// Do you want to enter the left of 9?
// false
// Do you want to enter the right of 9?
// false
// Do you want to enter the right of 15?
// false
// 15
//         8
//                 7
//                 9
// 7 and 9 are children of 8 hence in same level and 8 is child of 15.
// 15
// |       |------>9
// |------>8
// |       |------>7