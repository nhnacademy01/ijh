package linkedlist;

public class SinglyLinkedList {
    int size = 0;
    Node first;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addFirst("첫번째");
        singlyLinkedList.addLast("마지막");
        //singlyLinkedList.add(1,"두번째");
        System.out.println(singlyLinkedList.get(1));

    }

    static class Node {
        Object item;
        Node next;

        Node(Object element, Node next) {
            this.item = element;
            this.next = next;
        }
    }

    // first chapter
    public SinglyLinkedList() { }
    public void addFirst(Object o) {
        if(first == null) {
            first = new Node(o,null);
        } else {
            Node next = first;
            first = new Node(o, next);
        }
        this.size++;
    }
    public void addLast(Object o) {
        if (first == null) {
            first = new Node(o, null);
        } else {
            Node last = getLastNode();
            last.next = new Node(o, null);
        }
        this.size++;
    }
    private Node getLastNode() {
        if(first == null) {
            return null;
        }
        Node current = first;
        while (true) {
            if(current.next == null)
                return current;
            current = current.next;
        }
    }
    public void add(int index, Object o) {
        // index: 0 -> 첫번째 노드
        // index: 10 -> 11번째 노드로 끼어들기
        // index가 size를 넘으면 IndexOutOfBoundException 발생할 수 있음.
        Node prev = getNode(index-1);
        Node next = getNode(index);
        Node current = new Node(o,next);
        prev.next = current;
        this.size++;
    }
    private Node getNode(int index) {
        checkIndex(index);
        if(index == 0) {
            return first;
        }

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index +" + 에 위치하는 노드가 없어요");
    }

    // second chapter
    public Object getFirst() {
        return this.first.item;
    }
    public Object getLast() {
        assert getLastNode() != null;
        return getLastNode().item;
    }
    public Object get(int index) {
        for (int i = 0; i < this.size; i++) {
            if(this.first.item == getNode(index).item){
                return this.getNode(i).item;
            }
        }
        return null;
    }
    public int indexOf(Node o) {
        for (int i = 0; i < size; i++) {
            if(getNode(i).item == o.item){
                return i;
            }
        }
        return 0;
    }
    public void clear() { }
    public Object removeFirst() {
        return null;
    }
    public Object removeLast() {
        return null;
    }
    public Object remove(int index) {
        return null;
    }
}

