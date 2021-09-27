package xyz.admacro.misc;

// This class demonstrates how to reverse a linked list.
public class ReverseLinkedList {
    public static void main(String[] args) {
        int nodeCount = 3;
        if (args != null && args.length == 1) {
            nodeCount = Integer.valueOf(args[0]);
        }
        ReverseLinkedList rll = new ReverseLinkedList();
        System.out.println(rll.reverse(rll.linkedList(nodeCount)));
    }

    public Node reverse(Node n) {
        if (n == null) {
            return null;
        } else if (n.next == null) { // one node
            return n;
        } else {                // more than one node
            Node r = n;
            Node t = n.next;

            // the first round
            n = t;
            t = t.next;
            r.next = null;      // this is only needed for the first node
            n.next = r;
            r = n;

            while (t != null) {
                n = t;
                t = t.next;
                n.next = r;
                r = n;
            }
            return r;
        }
    }

    // generate linkedlist with nodeCount nodes:
    // for example: if nodeCount is 4, this will generate 1->2->3->4
    Node linkedList(int nodeCount) {
        Node node = null;
        for (int i = nodeCount; i > 0; i--) {
            node = new Node(i, node);
        }
        return node;
    }

    class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node counter = this;
            stringBuilder.append(counter.value);
            while (counter.next != null) {
                stringBuilder.append("->").append(counter.next.value);
                counter = counter.next;
            }
            return stringBuilder.toString();
        }
    }
}
