package com.practice.simulationproblems;
import java.io.*;
import java.util.*;

/**
Problem statement:

Make a Queue backed by a linked list

It should have the following methods.

//this method should have O(1) time and add a node to the head of the queue
void add(int i);

//this method should have a O(1) run time and remove the value at the head of the queue and return it
int remove();

//this method should return the value {a}t the head of the queue in O(1) time but not remove it
int peek();

//this method should add all the elements of a list to the queue
void addAll(List<Integer> list);

//this method should return whether the queue is empty or not in O(1) time
boolean isEmpty();

//this method should return the number of elements in the queue in O(1) time
int size();

---------------------------------------------------

test code:
Queue q = new Queue();

q.add(1);
q.add(3);
q.add(5);
q.add(7);

System.out.println(q.size()); //should print 4;
System.out.println(q.poll()); //should print 1;
System.out.println(q.remove()); //should print 1;
System.out.println(q.poll()); //should print 3;
System.out.println(q.size()); //should print 3;

q.addAll(List.of(9, 11, 12));

System.out.println(q.size()); //should print 6;
System.out.println(q.isEmpty()); //should print false;

System.out.println(q.remove()); //should print 3;
System.out.println(q.remove()); //should print 5;
System.out.println(q.remove()); //should print 7;
System.out.println(q.remove()); //should print 9;
System.out.println(q.remove()); //should print 11;
System.out.println(q.remove()); //should print 12;

System.out.println(q.size()); //should print 0;
System.out.println(q.isEmpty()); //should print true;

*/



public class CreateQueueBackedByLinkedList {
    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);

        System.out.println(q.size()); //should print 4;
        System.out.println(q.peek()); //should print 1;
        System.out.println(q.remove()); //should print 1;
        System.out.println(q.peek()); //should print 3;
        System.out.println(q.size()); //should print 3;
        List<Integer> testList= new ArrayList<>();
        testList.add(9);
        testList.add(11);
        testList.add(12);
        q.addToList(testList);

        for( Integer i: testList){
            System.out.print(i + " ");
        }
        System.out.println();


        System.out.println("The size of the queue is " + q.size()); //should print 6;
        System.out.println(q.isEmpty()); //should print false;
        System.out.println(q.remove()); //should print 3;
        System.out.println(q.remove()); //should print 5;
        System.out.println(q.remove()); //should print 7;
        System.out.println(q.remove()); //should print 9;
        System.out.println(q.remove()); //should print 11;
        System.out.println(q.remove()); //should print 12;
        System.out.println(q.size()); //should print 0;
        System.out.println(q.isEmpty()); //should print true;
    }
}

class Queue{
    private LinkedList list;

    Queue(){
        list = new LinkedList();
    }
    //addToQueue
    public void add(int val){
        list.insertAtHead(val);
    }
    //removeFromQueue
    public int remove(){
        return list.removeFromHead();
    }
    //peek
    public int peek(){
        return list.head.val;
    }
    //addToList
    public void addToList(List<Integer> tempList){
        // tempList.addAll(list.addAll());

        for( Integer i : tempList){
            add(i);
        }
    }
    //isEmpty()
    boolean isEmpty(){
        return list.size == 0;
    }
    //size
    public int size(){
        return list.traverseAll();
    }
}
class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
class LinkedList{
    Node head;
    public Node tail;
    int size =0;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //add to LinkedList method
    public void insertAtHead(int val){
        Node temp = new Node(val);
        if( head == null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    //remove from LinkedList method
    public int removeFromHead(){
        if(head != null){
            int result = head.val;
            head = head.next;
            size--;
            return result;
        }else{
            System.out.print(" The list is empty!");
            return -1;
        }
    }
    public List<Integer>addAll (){
        Node node = head;
        List<Integer> list = new ArrayList<>();
        while(node != null){
            list.add(node.val );
            node = node.next;
        }
        return list;
    }
    public int traverseAll(){
        int count=0;
        Node node = head;
        while(node != null){
            // System.out.print(node.val + " count" + count + " ");
            count++;
            node = node.next;
        }
        return count;
    }
}
