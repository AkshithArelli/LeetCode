~~~java
package DSA;

public class LL {
    private Node head;
    private int size;

    LL () {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add first, add last
    public void addFirst (String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast (String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        //null
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        //if only one node is present
        //eg:   1   ->  null
        //    head
        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        // 1 -> 2 -> 3 -> null
        // sL   l      -> first iteration
        //      sl   l -> second iteration
        // comes out of while loop, sl is set to null ie 3 is removed
        //result: 1 -> 2 -> null
        Node secondLast = head;
        Node last = head.next;  //the above condition takes care of next node being null
        while (last.next != null) {
            last = last.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        if (head == null) {
            System.out.print("list is empty");
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("linkedList");
        list.addFirst("this");
        list.printList();
        System.out.println();
        list.deleteFirst();
        list.printList();
        System.out.println();
        list.deleteLast();
        list.printList();
        System.out.println();
        System.out.println(list.getSize());
    }
}
~~~
