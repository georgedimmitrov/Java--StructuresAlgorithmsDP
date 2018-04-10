package ArrayStructures;

import java.util.Arrays;

public class Stack {
    private String[] stackArray;

    private int stackSize;

    private int topOfStack = -1;

    Stack(int size) {
        stackSize = size;
        stackArray = new String[size];

        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {

        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else {
            System.out.println("Sorry But the Stack is Full");
        }

        displayStack();

        System.out.println("PUSH " + input + " Was Added to the Stack\n");
    }

    public void pushMany(String multipleValues) {
        String[] tempString = multipleValues.split(" ");

        for (int i = 0; i < tempString.length; i++) {
            push(tempString[i]);
        }
    }

    public String pop() {
        if (topOfStack >= 0) {
            displayStack();

            System.out.println("POP " + stackArray[topOfStack] + " was removed from the Stack.");

            stackArray[topOfStack] = "-1";

            return stackArray[topOfStack--];
        } else {
            displayStack();

            System.out.println("Sorry, stack is empty.");

            return "-1";
        }
    }

    public void popAll() {
        for (int i = topOfStack; i >= 0; i--) {
            pop();
        }
    }

    public String peek() {
        displayStack();

        System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the Stack.");

        return stackArray[topOfStack];
    }

    public void displayStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){



            if(stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

    public static void main(String[] args) {
        Stack theStack = new Stack(10);

        theStack.push("10");
        theStack.push("15");
        theStack.peek();
        theStack.pop();
        theStack.pushMany("12 13 14 15");
        theStack.popAll();
        theStack.displayStack();
    }
}
