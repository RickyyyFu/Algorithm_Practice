package TwoSigma;

import java.util.*;

/**
 * if there are n entries and b is the size of the array there would be n/b entries on each index. 
 * This value n/b is called the load factor that represents the load that is there on our map.
	This Load Factor needs to be kept low, so that number of entries at one index is less and so is the complexity almost constant, i.e., O(1).
 *
 * when the load factor increases to more than its pre-defined value (default value of load factor is 0.75), the complexity increases. 
 * So to overcome this, the size of the array is increased (doubled) 
 	and all the values are hashed again and stored in the new double sized array to maintain a low load factor and low complexity.
 *	
 * Why rehashing?
	Rehashing is done because whenever key value pairs are inserted into the map, the load factor increases, which implies that the time complexity also increases as explained above. 
	This might not give the required time complexity of O(1).
	Hence, rehash must be done, increasing the size of the bucketArray so as to reduce the load factor and the time complexity
 *
 *	How Rehashing is done?
	Rehashing can be done as follows:

	For each addition of a new entry to the map, check the load factor.
	If it¡¯s greater than its pre-defined value (or default value of 0.75 if not given), then Rehash.
	For Rehash, make a new array of double the previous size and make it the new bucketarray.
	Then traverse to each element in the old bucketArray and call the insert() for each so as to insert it into the new larger bucket array.
 */


public class DesignHashTable {
	class Map<K, V>{
		class Node<K, V>{
			K key;
			V value;
			Node next;
			
			public Node(K k, V v) {
				this.key = k;
				this.value = v;
				this.next = null;
			}
		}
		
		final double LOAD_FACTOR = 0.75;
		ArrayList<Node<K, V>> bucket;
		int capacity;
		int size;
		
		public Map() {
			this.capacity = 5;
			this.size = 0;
			bucket = new ArrayList<>(capacity);
			for(int i = 0; i < capacity; i++) {
				Node<K, V> head = null;
				bucket.add(head);
			}
		}
		
		public int getBucketIdx(K key) {
			int hashcode = key.hashCode();
			return hashcode % capacity;
		}
		
		public V get(K key) {
			Node<K, V> head = bucket.get(getBucketIdx(key));
			while(head != null) {
				if(head.key.equals(key)) return (V)head.value;
				head = head.next;
			}
			return null;
		}
		
		public void put(K key, V value) {
			int bucketIdx = getBucketIdx(key);
			Node<K, V> head = bucket.get(bucketIdx);
			while(head != null) {
				if(head.key.equals(key)) {
					head.value = value;
					return;
				}
				head = head.next;
			}
			
			// Î²²å·¨
			//head = new Node<K, V>(key, value);
			
			// Í·²å·¨
			// new node with the K and V 
	        Node<K, V> newElementNode = new Node<K, V>(key, value); 
	        // The head node at the index 
	        head = bucket.get(bucketIdx); 
	        // the new node is inserted 
	        // by making it the head 
	        // and it's next is the previous head 
	        newElementNode.next = head;
	        bucket.set(bucketIdx, newElementNode); 
	  
			
			size++;
			double loadfactor = size/capacity;
			if(loadfactor > LOAD_FACTOR) rehash();
		}
		
		public void rehash() {
			ArrayList<Node<K, V>> pre = bucket;
			bucket = new ArrayList<>(capacity*2);
			for(int i = 0; i < capacity*2; i++) {
				Node<K, V> head = null;
				bucket.add(head);
			}
			
			size = 0;
			capacity *= 2;
			for(int i = 0; i < pre.size(); i++) {
				Node<K, V> head = pre.get(i);
				while(head != null) {
					K key = (K) head.key;
					V value = (V) head.value;
					put(key, value);
					head = head.next;
				}
			}
		}
		
		public void printMap() 
	    { 
	  
	        // The present bucket list is made temp 
	        ArrayList<Node<K, V> > temp = bucket; 
	  
	        System.out.println("Current HashMap:"); 
	        // loop through all the nodes and print them 
	        for (int i = 0; i < temp.size(); i++) { 
	  
	            // head of the chain at that index 
	            Node<K, V> head = temp.get(i); 
	  
	            while (head != null) { 
	                System.out.println("key = " + head.key + ", val = " + head.value); 
	  
	                head = head.next; 
	            } 
	        } 
	        System.out.println(); 
	    } 
	}
	
	public static void main(String[] args) {
		DesignHashTable d = new DesignHashTable();
		Map<Integer, String> map = d.new Map<Integer, String>();
		 // Inserting elements 
        map.put(1, "Geeks"); 
        map.printMap(); 
  
        map.put(2, "forGeeks"); 
        map.printMap(); 
  
        map.put(3, "A"); 
        map.printMap(); 
  
        map.put(4, "Computer"); 
        map.printMap(); 
  
        map.put(5, "Portal"); 
        map.printMap(); 
	}
}
