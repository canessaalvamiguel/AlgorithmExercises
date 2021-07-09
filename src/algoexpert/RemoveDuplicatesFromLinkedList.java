/*
Link to problem: https://www.algoexpert.io/questions/Remove%20Duplicates%20From%20Linked%20List
* You're given the head of a Singly Linked List whose nodes are in sorted order
  with respect to their values. Write a function that returns a modified version
  of the Linked List that doesn't contain any nodes with duplicate values. The
  Linked List should be modified in place (i.e., you shouldn't create a brand
  new list), and the modified Linked List should still have its nodes sorted
  with respect to their values.


  Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to
  None / null if it's the tail of the list.

Sample Input
linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1
Sample Output
1 -> 3 -> 4 -> 5 -> 6// the head node with value 1*/

package algoexpert;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] args){
        LinkedList linkedList1 = new LinkedList(1);
        LinkedList linkedList2 = new LinkedList(1);
        LinkedList linkedList3 = new LinkedList(3);
        LinkedList linkedList4 = new LinkedList(4);
        LinkedList linkedList5 = new LinkedList(4);
        LinkedList linkedList6 = new LinkedList(4);
        LinkedList linkedList7 = new LinkedList(5);
        LinkedList linkedList8 = new LinkedList(6);
        LinkedList linkedList9 = new LinkedList(6);

        linkedList1.next = linkedList2;
        linkedList2.next = linkedList3;
        linkedList3.next = linkedList4;
        linkedList4.next = linkedList5;
        linkedList5.next = linkedList6;
        linkedList6.next = linkedList7;
        linkedList7.next = linkedList8;
        linkedList8.next = linkedList9;

        LinkedList resultLinkedList = removeDuplicatesFromLinkedList(linkedList1);
        LinkedList currentNode = resultLinkedList;

        while( currentNode.next != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList){

        LinkedList currentNode = linkedList;

        while( currentNode != null){
            LinkedList nextNode = currentNode.next;
            if(  nextNode != null && currentNode.value == nextNode.value ){
                currentNode.next = nextNode.next;
            }else{
                currentNode = nextNode;
            }
        }
        return linkedList;
    }
}
