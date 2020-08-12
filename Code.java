import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
      
      int h = height(root);
      

      for(int i =1 ; i<= h ;i++){
          calculateLevelOrder(root, i);
      }
    }

    public static void calculateLevelOrder(Node n, int i){
        if(n == null){
            return;
        }
        if(i == 1){
            System.out.print(n.data + " ");
        }
        
        calculateLevelOrder(n.left, i-1);
        calculateLevelOrder(n.right, i-1);
    }
    public static int height(Node n){
        if(n == null){
            return 0;
        }
        else if(n.left == null && n.right == null){
            return 1;
        }
        else{
            return Math.max(height(n.left),height(n.right))+1;
        }
    } 

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
