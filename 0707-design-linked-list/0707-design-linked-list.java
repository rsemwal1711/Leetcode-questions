class Node{
    int data;
    Node next;
    
    Node(){}
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {
    Node head;
    public MyLinkedList() {
        head = new Node();
    }
    
    public int get(int index) {
        if(index == 0){
            if(head.next == null) return -1;
            return head.next.data;
        }
        Node temp = head.next;
        int i=0;
        while(temp != null){
            if(i == index){
                return temp.data;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head.next = newNode;
            return;
        }
        newNode.next = head.next;
        head.next = newNode;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        int i=0;
        while(temp.next != null && i < index){
            i++;
            temp = temp.next;
        }
        if(i != index) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;
        int i=0;
        while(temp.next != null && i < index){
            i++;
            temp = temp.next;
        }
        if(temp.next == null) return;
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */