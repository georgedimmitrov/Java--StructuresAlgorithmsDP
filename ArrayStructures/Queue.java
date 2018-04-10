package ArrayStructures;

import java.util.Arrays;

public class Queue {
    private String[] queueArray;

    private int queueSize;

    private int front, rear, numberOfItems = 0;

    Queue(int size) {
        queueSize = size;
        queueArray = new String[size];
        Arrays.fill(queueArray, "-1");
    }

    public void insert(String input) {
        if (numberOfItems + 1 <= queueSize) {
            queueArray[rear] = input;

            rear++;
            numberOfItems++;

            System.out.println("INSERT " + input + " was added to queue.");
        } else {
            System.out.println("Sorry, queue is full.");
        }
    }

    public void priorityInsert(String input) {
        int i;

        if (numberOfItems == 0) {
            insert(input);
        } else {
            for (i = numberOfItems - 1; i >= 0; i--) {
                if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
                    queueArray[i + 1] = queueArray[i];
                } else {
                    break;
                }
            }

            queueArray[i + 1] = input;
            rear++;
            numberOfItems++;
        }
    }

    public void remove() {
        if (numberOfItems > 0) {
            System.out.println("REMOVE " + queueArray[front] + " was removed from queue.");

            queueArray[front] = "-1";

            front++;
            numberOfItems--;
        } else {
            System.out.println("Sorry, queue empty.");
        }
    }

    public void peek() {
        System.out.println("The first element is " + queueArray[front]);
    }

    public void displayQueue(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){


            if(queueArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", queueArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3*(2*(front+1)-1);

        for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);

        for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.priorityInsert("10");
        queue.priorityInsert("19");
        queue.priorityInsert("15");
        queue.priorityInsert("11");
        queue.displayQueue();
        queue.remove();
        queue.displayQueue();
        queue.peek();
        queue.remove();
        queue.remove();
    }
}
