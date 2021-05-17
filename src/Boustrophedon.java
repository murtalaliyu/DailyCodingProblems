import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class binaryTree {
	int data;
	binaryTree left;
	binaryTree right;
	
	binaryTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

/*
 * In Ancient Greece, it was common to write text with the 
 * first line going left to right, the second line going right to left, 
 * and continuing to go back and forth. This style was called "boustrophedon".
Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
For example, given the following tree:
       1
    /     \
  2         3
 / \       / \
4   5     6   7
You should return [1, 3, 2, 4, 5, 6, 7].
 */
public class Boustrophedon {
	public static void main(String[] args) {
		binaryTree tree = new binaryTree(1);
		tree.left = new binaryTree(2);
		tree.right = new binaryTree(3);
		tree.left.left = new binaryTree(4);
		tree.left.right = new binaryTree(5);
		tree.right.left = new binaryTree(6);
		tree.right.right = new binaryTree(7);
		
		//System.out.println(bfs(tree, 0));
		bfs(tree,0);
		zigzag();
		
		/*
		bfs_queue(tree);
		for (binaryTree a : al) {
			System.out.print(a.data + ", ");
		}
		*/
	}
	
	
	public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	public static void bfs(binaryTree root, int depth) {
		if (root == null) {
			return;
		}
		
		if (!map.containsKey(depth)) {
			map.put(depth, new ArrayList<Integer>());
		}
		
		map.get(depth).add(root.data);
		
		bfs(root.left, depth+1);
		bfs(root.right, depth+1);
		
		return;
	}
	
	public static void zigzag() {
		for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
			int key = e.getKey();
						
			// if even
			if (key % 2 == 0) {
				ArrayList<Integer> value = e.getValue();
				for (int i = 0; i < value.size(); i++) {
					System.out.print(value.get(i) + "\t");
				}
				System.out.println();
			}
			
			// if odd
			else if (key % 2 != 0)
			{
				ArrayList<Integer> value = e.getValue();
				//System.out.println("odd value: " + value);
				for (int i = value.size()-1; i >= 0; i--) {
					System.out.print(value.get(i) + "\t");
				}
				System.out.println();
			}
			
		}
	}
}
