package Provided;

public class ListNode {
    private final char[][] bitmap;
    private ListNode next;


    public ListNode(char[][] bitmap) {
        this.bitmap = bitmap;
        next = null;
    }


    public char[][] getBitmap() {
        return bitmap;
    }


    public ListNode getNext() {
        return next;
    }



    public void setNext(ListNode next) {
        this.next = next;
    }
}

