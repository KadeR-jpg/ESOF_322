package Proj4;

import java.util.NoSuchElementException;

/**
 * Project 04
 *
 * 1. Implement Stack and Queue interfaces using DoublyLinkedList (provided)
 * to create and demo the Stack and Queue ADTs
 *
 * a. Create a class DLLStack to implement the Stack interface,
 * b. Create a class DLLQueue to implement the Queue interface.
 *
 *
 * 2. Implement Stack interface using Array (you create)
 *  to create and demo the Stack ADT
 *
 * a. Create a class ArrayStack (capacity of 10) to implement the Stack interface
 * !! HINT: See the book, page 230 -- it shows how to do this. You may use it. Type, don't paste.
 *
 *
 * Provided: Stack.java (interface), Queue.java (interface), DoubleLinkedList.java (class)
 * Deliverables: DLLStack.java, DLLQueue.java, ArrayStack.java
 *
 * 3. Using your new ATDs, develop a method to test whether a string is a palindrome.
 * A palindrome is a word or phrase that is spelled the same backwards as forwards,
 * ie: "level" or "race car" or "a man a plan a canal panama"
 *
 * Use the StackQueueDemo driver class to demo your ATDs. You should push and pop elements from the Stacks,
 * enque and deque elements from the Queue, demo the size and isEmpty methods for all.
 * Test a real palindrome, and a fail.
 *
 *
 */
public class StackQueueDemo {

    public static void main(String[] args) {

        // test doubly linked list stack
        DLLStack<String> dllTestStack = new DLLStack<>();

        dllTestStack.push("one");
        dllTestStack.push("two");
        dllTestStack.push("three");
        dllTestStack.push("four");
        dllTestStack.push("five");

        System.out.println(dllTestStack.toString());

        dllTestStack.pop();
        dllTestStack.pop();
        System.out.println(dllTestStack.toString());

        System.out.println(PalindromeTest.testPalindrome("taco cat"));
        System.out.println(PalindromeTest.testPalindrome("hot dog"));


        // test array stack
        ArrayStack<Double> arrayTestStack = new ArrayStack<>();

        arrayTestStack.push(10.1);
        arrayTestStack.push(12.2);
        arrayTestStack.push(14.4);
        arrayTestStack.push(16.6);
        arrayTestStack.push(18.8);

        System.out.println(arrayTestStack.toString());

        arrayTestStack.pop();
        arrayTestStack.pop();
        System.out.println(arrayTestStack.toString());


        // test doubly linked list queue
        DLLQueue<Integer> dllTestQueue = new DLLQueue<>();

        dllTestQueue.enqueue(10);
        dllTestQueue.enqueue(20);
        dllTestQueue.enqueue(30);
        dllTestQueue.enqueue(40);
        dllTestQueue.enqueue(50);

        System.out.println(dllTestQueue.toString());

        dllTestQueue.dequeue();
        dllTestQueue.dequeue();
        System.out.println(dllTestQueue.toString());


    }
    /**
     * @DLLStack
     *      gives us a class to build a stack out of a DLL.
     * @param <E>
     *     takes in our generic type and uses it in our generic
     *     stack.
     *
     *
     */
    public static class DLLStack<E> implements Stack<E> {
        private Node<E> top;
        private int size;

        private class Node<E>{
            private E item;
            private Node<E> next;
        }

        /**
         * builds our empty stack
         */
        public void Stack() {
            top = null;
            size = 0;
        }

        /**
         * @return
         *      returns the top item of our stack
         */
        public E top() {
            return top.item;
        }

        /**
         * @return
         *     null if the stack is empty
         */
        public boolean isEmpty() {
            return top == null;
        }

        /**
         * @return
         *      returns the size of the stack
         */
        public int size() {
            return size;
        }

        /**
         * @param item
         *      pushes our object down the stack
         */

        public void push(E item) {
            Node<E> prevTop = top;
            top = new Node<E>();
            top.item = item;
            top.next = prevTop;
            size++;
        }

        /**
         * @return
         *      once the item is popped out of the stack its
         *      value is returned.
         */
        public E pop() {
            if (isEmpty()) throw new NoSuchElementException("Stack Underflow");
            E item = top.item;
            top = top.next;
            size--;
            return item;
        }

        /**
         *
         * @return
         *      return the top element of our stack without
         *      manipulating the stack.
         */

        public E peek() {
            if (isEmpty()) throw new NoSuchElementException("Stack Underflow");
            return top.item;
        }

        /**
         * Our overide String method.
         * @return
         *      returns the string
         */
        public String toString() {
            String result = "";
            Node<E> current = top;
            System.out.print("(");
            while (current != null) {
                result = result + current.item + ", ";
                current = current.next;
            }
            return result + ")";
        }


    }

    /**
     * DLLQueue
     *      gives us a class to build a queue off a DLL.
     *
     * @param <E>
     *     takes a generic type to build into our generic queue
     */
    public static class DLLQueue<E> implements Queue<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size;

        private class Node<E> {
            private E item;
            private Node<E> next;
        }

        /**
         * @return
         *      returns the top("head") of our Queue
         */
        public E first() {
            return head.item;
        }

        /**
         * @return
         *      returns if the queue is empty
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * @return
         *      returns the size of our Queue
         */
        public int size() {
            return size;
        }

        /**
         * @return
         *      lets us look at the top of our queue without
         *      manipulating it
         */
        public E peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue Under");
            return head.item;
        }

        /**
         * @param item
         *      adds an object to the back of our queue
         */
        public void enqueue(E item) {
            Node<E> prevTail = tail;
            tail = new Node<>();
            tail.item = item;
            tail.next = null;
            if (isEmpty()) head = tail;
            else prevTail.next = tail;
            size++;
        }

        /**
         * @return
         *      removes the object from the front of the queue
         */
        public E dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue Under");
            E item = head.item;
            head = head.next;
            size--;
            if (isEmpty()) tail = null;
            return item;
        }

        /**
         * @return
         *      our string override method
         */
        public String toString() {
            String result = "";
            Node<E> current = head;
            System.out.print("(");
            while (current != null) {
                result = result + current.item.toString() + ", ";
                current = current.next;
            }
            return result + ")";
        }
    }

    /**
     * @param <E>
     *     a class that will add arrays to a stack
     */
    static class ArrayStack<E> implements Stack<E> {
        public static final int CAP = 10;
        private E[] data;
        private int t = -1;

        public ArrayStack() {
            this(CAP);
        }

        public ArrayStack(int capacity) {
            data = (E[]) new Object[capacity];
        }

        public int size() {
            return (t + 1);
        }

        public boolean isEmpty() {
            return (t == -1);
        }

        public void push(E e) throws IllegalStateException {
            if (size() == data.length) throw new IllegalStateException("Stack is Full");
            data[++t] = e;
        }

        public E top() {
            if (isEmpty()) return null;
            return data[t];
        }

        public E pop() {
            if (isEmpty()) return null;
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }

        public String toString() {
            StringBuilder StringBuild = new StringBuilder();
            StringBuild.append("(");
            for (int i = 0; i < size() - 1; i++) {
                StringBuild.append(data[i]);
                StringBuild.append(", ");
            }
            StringBuild.append(data[size() - 1]);
            StringBuild.append(")");
            return StringBuild.toString();
        }
    }

    /**
     * testing if a string is a palindrome
     */
    static class PalindromeTest {
        public static boolean testPalindrome(String pal){
            String original = pal.replaceAll("\\s+", "");
            String reverse = "";
            for(int i = original.length() - 1; i >= 0; i--){
                reverse = reverse + original.charAt(i);
            }
            if(reverse.equals(original)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}