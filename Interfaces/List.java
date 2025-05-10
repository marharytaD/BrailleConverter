
package Interfaces;
import Provided.ListNode;

public interface List {
    int size();

    void addFirst(ListNode newNode);
    ListNode getFirst();
    ListNode removeFirst();

    void addLast(ListNode newNode);
    ListNode getLast();
    ListNode removeLast();

    ListNode get(int index);
    void insert(ListNode newNode, int index);
    ListNode remove(int index);

    void clear();

    ListNode debugGetHead();
    ListNode debugGetTail();
}


