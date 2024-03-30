package ds.stacksAndQueues;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args)
    {
        int[] arr = { 11, 13, 21, 3 };
        printNSE(arr);
    }

    static void printNSE(int[] arr){
        Stack<Integer> stack = new Stack<>();          //stack to store indexes of elements for which no smaller element is found yet
        int[] ans = new int[arr.length];                //array to store NSE for each index

        stack.push(0);      //add first element's index to stack

        for(int i=1; i<arr.length; i++){
            int next = arr[i];

            while(!stack.isEmpty() && next<arr[stack.peek()]){      //for all stack elements for which curr ele is smaller, curr will be the ans
                ans[stack.peek()] = next;
                stack.pop();
            }

            stack.push(i);      //push curr ele's pos to stack
        }

        while(!stack.isEmpty())             //for all elements left in stack, NSE will be -1
            ans[stack.pop()] = -1;

        for(int i=0; i<arr.length; i++)
            System.out.print(ans[i]+" ");
    }
}
