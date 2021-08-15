package wang.haoxu.easy.class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Code03_TreeMaxWidth {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	// 二叉树的宽度优先遍历
	public static void w(Node head) {
		Queue<Node> queue = new LinkedList();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.print(cur.value + "----");
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}
	public static int getMaxWidth(Node head) {
		if (head == null) {
			return 0;
		}
		int maxWidth = 0;
		int curWidth = 0;
		int curLevel = 0;
		HashMap<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		Node node = null;
		Node left = null;
		Node right = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			left = node.left;
			right = node.right;
			if (left != null) {
				levelMap.put(left, levelMap.get(node) + 1);
				queue.add(left);
			}
			if (right != null) {
				levelMap.put(right, levelMap.get(node) + 1);
				queue.add(right);
			}
			if (levelMap.get(node) > curLevel) {
				curWidth = 0;
				curLevel = levelMap.get(node);
			} else {
				curWidth++;
			}
			maxWidth = Math.max(maxWidth, curWidth);
		}
		return maxWidth;
	}
	public static int getMaxWidth2(Node head) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node curend = head;
		Node nextend = null;
		int nodes = 0;
		int max = -1;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.left != null) {
				queue.add(cur.left);
				nextend = cur.left;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nextend = cur.right;
			}
			if (cur != curend) {
				nodes++;
			} else {
				nodes++;
				max = Math.max(max, nodes);
				nodes = 0;
				curend = nextend;
				nextend = null;
			}
		}
		return Math.max(max, nodes);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
