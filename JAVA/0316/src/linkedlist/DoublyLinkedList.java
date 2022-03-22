package linkedlist;

public class DoublyLinkedList {
    // 멤버
    int size = 0;
    Node first;
    Node last;

    // 중첩클래스
    static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Node element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // first chapter
    public DoublyLinkedList() { }
    public void addFirst(Object o) { }
    public void addLast(Object o) { }
    public void add(int index, Object o) { }
}
