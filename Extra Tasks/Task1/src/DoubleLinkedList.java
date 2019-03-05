/*
This is a class which creates and tests an ADT of type queue based on the doubly linked list format.
The data type accepted into the linked list is integers, and in order to create the queue, and the first entry, a constructor is provided
that accepts argument int for the first data point. The method deqFirst dequeues the front element of the list, and returns this.
The method enq enqueues the element given as argument to the back of the queue. The main method enqueues values 1, 2, 3 and 4,
writes out the values stored in the first and second position of the queue, and last and second last positions. It then
dequeues 4 times, printing the result each time.
 */


public class DoubleLinkedList {
    Node first;     //create pointers for the first and last nodes
    Node last;

    private class Node {
        int value;      //define a node as having an integer value and having a previous and next node
        Node next;
        Node previous;

        public Node(int value) {        //create a constructor for a node so one can initialize a node ith a value
            this.value = value;
        }

        @Override
        public String toString() {      // allow for printing of nodes by the value

            return "[" + this.value + "], ";
        }


    }

    public DoubleLinkedList(int[] values) {        //add a constructor for a linked list queue that accepts predefined values
        int i = 1;
        Node n = new Node(values[0]);
        this.first = n;
        this.last = n;
        while (i < values.length){
            enq(values[i]);
            i++;
        }
    }

    public void enq(int value) {            //method for adding a new node to the end of the linked list
        Node newNode = new Node(value);     //create a new node with the value given to enqueue
        Node oldLast = this.last;           //create a pointer to point to the second last node
        this.last = newNode;                //set the pointer for the last node of the list to point to the new node
        this.last.previous = oldLast;       //connect new node to chain
        oldLast.next = last;                //connect previously last node to new node


    }

    public Node deqFirst() {             //method for removing a node
        Node poppify = this.first;  //point to the node we want to pop
        this.first = first.next;    //move the pointer towards the front of the list to the previously second first node
        return poppify;             //return the first node
    }

    public Node deqLast() {     //method for removing the last item in the list
        Node pop = this.last;
        this.last = last.previous;
        return pop;
    }

    public static void main(String args[]){     //test program for the linked list
       // if (args[0] == "test") {
            int[] values = {5, 4, 3, 2};
            DoubleLinkedList numbaz = new DoubleLinkedList(values);
            System.out.print(numbaz.first);
            System.out.println(numbaz.first.next);
            System.out.print(numbaz.last);
            System.out.println(numbaz.last.previous);
            System.out.print(numbaz.deqFirst());
            System.out.print(numbaz.deqFirst());
            System.out.print(numbaz.deqLast());
            System.out.print(numbaz.deqLast());
      //  }





    }
}