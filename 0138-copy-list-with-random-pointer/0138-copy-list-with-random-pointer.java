/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       
        Map<Node,Node> map = new HashMap<>();
        return clone(map,head);
    }
    private Node clone(Map<Node,Node> map,Node head){
        Node copy;
       
        Node temp = head;
        while(temp!=null){
            copy = new Node(temp.val);
            map.put(temp,copy);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}