/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if (head == null)
        return false;

    Node fastPointer = head.next;
    Node slowPointer = head;

    while (slowPointer != fastPointer) {
        if (fastPointer == null || fastPointer.next == null)
            return false;
        fastPointer = fastPointer.next.next;
        slowPointer = slowPointer.next;
    }

    return true;
}
