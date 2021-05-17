/*
 * An XOR linked list is a more memory efficient doubly linked list. 
 * Instead of each node holding next and prev fields, 
 * it holds a field named both, which is an XOR of the next node and the previous node. 
 * Implement an XOR linked list; it has an add(element) which adds the element to the end, 
 * and a get(index) which returns the node at index.
 */
class XORLList {
	int data;
	XORLList both;
	
	XORLList(int data) {
		this.data = data;
		both = null;
	}
}

public class XOR {
	static XORLList head, prev, next; 
	
	public static void main(String[] args) {
		System.out.println(new XORLList(10));
	}
	
	static void add(int data, int addr) {
		//int xor = 200^600;
		XORLList node = new XORLList(data);
		if (head == null) {
			head = node;
		} else {
			XORLList n = head;
			prev = null;
			while (n.both != null) {
				int temp = n.both ^ getnt(prev);
				prev = n;
			}
			n.next = node;
		}
		
		
		
		
		prev = node.both;
		
	}
	
	static XORLList get() {
		
	}
}
