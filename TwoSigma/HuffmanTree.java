package TwoSigma;

import java.util.*;

/**
 * 	Tree + encodeMap + decodeMap
 *	Map + PriorityQueue + Node
 */

public class HuffmanTree {
	Node root;
	Map<Character, Integer> freq_map = new HashMap<>();
	Map<Character, String> encode_map = new HashMap<>();
	Map<String, Character> decode_map = new HashMap<>();
	
	PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.freq-b.freq));
	
	class Node {
		char c;
		int freq;
		Node left;
		Node right;
		
		public Node(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}
	
	// build huffman tree, encode map and decode map
	public void build(String s) {
		if(s.length() == 0 || s == null) {
			this.root = null;
			return;
		}
		
		for(char c : s.toCharArray()) {
			freq_map.put(c, freq_map.getOrDefault(c, 0)+1);
		}
		
		for(char c : freq_map.keySet()) {
			Node node = new Node(c, freq_map.get(c));
			pq.offer(node);
		}
		
		while(pq.size() > 1) {
			Node right = pq.poll();
			Node left = pq.poll();
			
			Node parent = new Node(' ', left.freq+right.freq);
			parent.left = left;
			parent.right = right;
			pq.offer(parent);
		}
		this.root = pq.poll();
		
		// dfs the tree to create encode/decode map
		dfs(encode_map, decode_map, root, "");
	}
	
	public void dfs(Map<Character, String> encode_map, Map<String, Character> decode_map, Node node, String s) {
		if(node == null) return;
		if(node.left == null && node.right == null) {
			encode_map.put(node.c, s);
			decode_map.put(s, node.c);
			return;
		}
		
		dfs(encode_map, decode_map, node.left, s+"0");
		dfs(encode_map, decode_map, node.right, s+"1");
	}
	
	public String encode(String s) {
		build(s);
		
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			sb.append(encode_map.get(c));
		}
		return sb.toString();
	}
	
	public String decode(String s) {
		StringBuilder sb = new StringBuilder();
		int left = 0, right = 0;
		while(right <= s.length()) {
			String code = s.substring(left, right);
			if(decode_map.containsKey(code)) {
				sb.append(decode_map.get(code));
				left = right;
			}
			else {
				right++;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		HuffmanTree ht = new HuffmanTree();
		System.out.println(ht.encode("aaaaabbbbcccdde"));
		System.out.println(ht.decode(ht.encode("aaaaabbbbcccdde")));
		
		System.out.println(ht.encode(""));
		System.out.println(ht.decode(""));
	}
}
