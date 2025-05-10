import Interfaces.List;
import Provided.ListNode;
public class BrailleLinkedList implements List {
    private ListNode head;
    private ListNode tail;
    private int size;



    public BrailleLinkedList() {
        this.head = null;
        this.tail= null;
        this.size =0;
    }


    @Override
    public int size() {
        // TODO: implementation
        return size;
    }


    @Override
    public void addFirst(ListNode newNode) {
        if (newNode == null){
            return;
        }
        newNode.setNext(head);
        head =newNode;
        if (tail==null){
            tail=newNode;
        }
        size++;
    }


    @Override
    public ListNode getFirst() {
        // TODO: implementation
        return head;
    }

    @Override
    public ListNode removeFirst() {
        if (head==null){
            return null;
        }
        ListNode removedNode = head;
        head =head.getNext();
        if (head==null){
            tail=null;
        }
        size--;
        return removedNode;
    }


    @Override
    public void addLast(ListNode newNode) {
        if (newNode ==null){
            return;
        }
        if (tail==null){
            head=tail=newNode;
        }else{
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
    }


    @Override
    public ListNode getLast() {
        // TODO: implementation
        return tail;
    }


    @Override
    public ListNode removeLast() {
        if (head==null){
            return null;
        }
        if (head ==tail){
            ListNode removedNode =head;
            head=tail=null;
            size--;
            return removedNode;
        }
        ListNode current =head;
        while(current.getNext()!=tail){
            current=current.getNext();
        }
        ListNode removedNode =tail;
        tail=current;
        tail.setNext(null);
        size--;
        return removedNode;
    }


    @Override
    public ListNode get(int index) {
        if (index<0||index>=size){
            return null;
        }
        ListNode current =head;
        for (int i = 0; i < index; i++) {
            current =current.getNext();
        }
        return current;
    }


    @Override
    public void insert(ListNode newNode, int index) {
        if (newNode ==null){
            return;
        }
        if (index<=0){
            addFirst(newNode);
            return;
        }
        ListNode current =head;
        for (int i = 0; i < index-1; i++) {
            current=current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }



    @Override
    public ListNode remove(int index) {
        if (index<0){
            return removeFirst();
        }
        if (index>=size){
            return removeLast();
        }
        if (index ==0){
            return removeFirst();
        }
        ListNode previous =null;
        ListNode current =head;
        for (int i = 0; i < index; i++) {
            previous=current;
            current =current.getNext();
        }
        previous.setNext(current.getNext());
        if (current==tail){
            tail=previous;
        }
        size--;
        return current;
    }


    @Override
    public void clear() {
        head =tail=null;
        size=0;
    }


    @Override
    public ListNode debugGetHead() {
        return head;
    }


    @Override
    public ListNode debugGetTail() {
        return tail;
    }

}


