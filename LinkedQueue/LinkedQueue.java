package LinkedQueue;

public class LinkedQueue {
	Node first, last;
	int n;
	
	class Node{
		int item;
		Node next;
	}
	
	public LinkedQueue() {
		this.first = null;
		this.last = null;
		this.n = 0;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void enqueue(int k) {
		Node oldlast = last;
		last = new Node();
		last.item = k;
		last.next = null;
		
		if(isEmpty()) first = last;
		else oldlast.next = last;
		n++;
	}
	
	public int dequeue() {
		if(isEmpty()) return -1;
		
		int item = first.item;
		first = first.next;
		n--;
		
		if(isEmpty()) last = null;
		return item;
	}
	
	public static void main(String[] args){ 
		LinkedQueue q = new LinkedQueue(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        q.dequeue(); 
        System.out.println("Queue Front : " + q.first.item); 
        System.out.println("Queue Rear : " + q.last.item); 
    } 
}
