import java.util.Stack;
public class Prog36_Stack_Programs {
    // Reverse string using Stack
      static void funct(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop and print in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
    // Evaluation of Postfix expression
    static int evaluate(String[] arr) {

        Stack<Integer> st = new Stack<>();

        for (String s : arr) {

            if (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/") ||
                s.equals("^")) {

                int b = st.pop();
                int a = st.pop();

                switch (s) {
                    case "+":
                        st.push(a + b);
                        break;

                    case "-":
                        st.push(a - b);
                        break;

                    case "*":
                        st.push(a * b);
                        break;

                    case "/":
                        st.push((int)Math.floor((double)a / b));
                        break;

                    case "^":
                        st.push((int)Math.pow(a, b));
                        break;
                }
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
    /*
    Idea

    In a postfix expression:

    If the token is a number → Push it onto the stack.
    If the token is an operator:
    Pop the second operand.
    Pop the first operand.
    Perform the operation.
    Push the result back.

    Important: For -, /, and ^, the order matters.

    If you pop b first and then a, evaluate a op b, not b op a.
    */

    // Next Greater Element in Array
     /*
    Given an array arr[] of integers, determine the Next Greater Element (NGE) for every element in the array, maintaining the order of appearance.

    The Next Greater Element for an element x is defined as the first element to the right of x in the array that is strictly greater than x.
    If no such element exists for an element, its Next Greater Element is -1.
    Examples: 

    Input: arr[] = [1, 3, 2, 4]
    Output: [3, 4, 4, -1]
    Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
    */
    static int[] funct2(int[] arr){
        int n=arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){//Go from right to left
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "TCSNQT";
        funct(str);
    }
}
