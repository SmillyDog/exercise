package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的各种遍历算法,同一个包中的public类可以直接用，不用import
 */
public class Traversal {

	/**
	 * 前序遍历
	 */
	public void preTraversal(BinaryTree root) {
		if (root == null)
			return; // 递归什么时候结束
		System.out.print(root.value + ", ");
		preTraversal(root.left);
		preTraversal(root.right);
	}

	/**
	 * 中序遍历
	 */
	public void inTraversal(BinaryTree root) {
		if (root == null)
			return;
		inTraversal(root.left);
		System.out.print(root.value + ", ");
		inTraversal(root.right);
	}

	/**
	 * 后序遍历，递归思想
	 * 
	 * 如果二叉树为空，返回 如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
	 */
	public void postTraversal(BinaryTree root) {
		if (root == null)
			return;
		postTraversal(root.left);
		postTraversal(root.right);
		System.out.print(root.value + ", ");
	}

	/**
	 * 层次遍历，采用先进先出的队列实现
	 * 
	 * 1. 先将根节点入队(first in, first out) 2. 判断队列是否是空 3. 如果队列不为空，则进行出队，得到的节点打印输出 4.
	 * 如果所得节点的左子树不为空，则将其左子树入队 5. 如果所得节点的右子树不为空，则将其右子树入队 6. 返回2
	 */
	public void layerTraversal(BinaryTree root) {
		if (root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		while (!(queue.isEmpty())) {
			BinaryTree temp = queue.poll(); // 出队
			System.out.print(temp.value + ", ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		} // while循环结束
	}
}
