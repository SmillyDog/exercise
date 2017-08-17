package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ���ĸ��ֱ����㷨,ͬһ�����е�public�����ֱ���ã�����import
 */
public class Traversal {

	/**
	 * ǰ�����
	 */
	public void preTraversal(BinaryTree root) {
		if (root == null)
			return; // �ݹ�ʲôʱ�����
		System.out.print(root.value + ", ");
		preTraversal(root.left);
		preTraversal(root.right);
	}

	/**
	 * �������
	 */
	public void inTraversal(BinaryTree root) {
		if (root == null)
			return;
		inTraversal(root.left);
		System.out.print(root.value + ", ");
		inTraversal(root.right);
	}

	/**
	 * ����������ݹ�˼��
	 * 
	 * ���������Ϊ�գ����� �����������Ϊ�գ����������������������������������ʸ��ڵ�
	 */
	public void postTraversal(BinaryTree root) {
		if (root == null)
			return;
		postTraversal(root.left);
		postTraversal(root.right);
		System.out.print(root.value + ", ");
	}

	/**
	 * ��α����������Ƚ��ȳ��Ķ���ʵ��
	 * 
	 * 1. �Ƚ����ڵ����(first in, first out) 2. �ж϶����Ƿ��ǿ� 3. ������в�Ϊ�գ�����г��ӣ��õ��Ľڵ��ӡ��� 4.
	 * ������ýڵ����������Ϊ�գ�������������� 5. ������ýڵ����������Ϊ�գ�������������� 6. ����2
	 */
	public void layerTraversal(BinaryTree root) {
		if (root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		while (!(queue.isEmpty())) {
			BinaryTree temp = queue.poll(); // ����
			System.out.print(temp.value + ", ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		} // whileѭ������
	}
}
