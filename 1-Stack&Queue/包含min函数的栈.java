import java.util.Stack;

public class Solution {
    
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || node <= minStack.peek()) {
            minStack.push(node);
        }
    }
    
    public void pop() {
        int out = dataStack.pop();
        if(out == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
} 
