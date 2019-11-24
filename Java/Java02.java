
/**
   @author Faisal Akhtar
 */
package java02;

import java.util.ArrayList;
abstract class Stack {
    abstract void push(int item);
    abstract int pop();
    abstract void display();
}

class StaticStack extends Stack {
    private int[] stack;
    private int top;

    public StaticStack() {
        this.stack = new int[50];
        this.top = 0;
    }

    @Override
    void push(int item) {
        stack[top++] = item;
    }

    @Override
    int pop() {
        if(top==0)
            return -1;
        return (stack[--top]);
    }

    @Override
    void display() {
        System.out.print("Static Stack = ");
        for (int i=0; i<top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

class DynamicStack extends Stack {
    private ArrayList<Integer> stack;
    
    public DynamicStack() {
        stack = new ArrayList<Integer>();
    }

    @Override
    void push(int item) {
        stack.add(item);
    }

    @Override
    int pop() {
        return stack.remove(stack.size()-1);
    }

    @Override
    void display() {
        System.out.print("Dynamic Stack = ");
        for (int i=0; i<stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    
}

public class Java02 {

    public static void main(String[] args) {
        StaticStack myStaticStack = new StaticStack();
        
        myStaticStack.push(5);
        myStaticStack.push(10);
        myStaticStack.push(15);
        myStaticStack.push(20);
        myStaticStack.push(25);
        
        myStaticStack.display();
        
        System.out.println("Popped item : "+myStaticStack.pop());
        System.out.println("Popped item : "+myStaticStack.pop());
        
        myStaticStack.display();

        
        DynamicStack myDynamicStack = new DynamicStack();
        
        myDynamicStack.push(5);
        myDynamicStack.push(10);
        myDynamicStack.push(15);
        myDynamicStack.push(20);
        myDynamicStack.push(25);
        
        myDynamicStack.display();
        
        System.out.println("Popped item : "+myDynamicStack.pop());
        System.out.println("Popped item : "+myDynamicStack.pop());
        
        myDynamicStack.display();
    }
    
}
