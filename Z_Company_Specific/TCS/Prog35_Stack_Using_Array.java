class Stack {
    int[] arr = new int[1000];
    int top = -1;

    void push(int x) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
public class Prog35_Stack_Using_Array {
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());   // 30
        System.out.println(st.pop());    // 30
        System.out.println(st.peek());   // 20
        System.out.println(st.isEmpty());// false
    }
}
