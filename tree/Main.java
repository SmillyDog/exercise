package tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = { 11, 2, 3, 4, 5, 6, 7, 8 };
		BinaryTree root = new BinaryTree(list[0]); // ��������
		// BinaryTree.initializeBTree(root, list, 0);
		/**
		 * 11 
		2       3 
	4      5   6  7 
8
		 */
		root.addLeftNode(root, list[1]);
		root.addRightNode(root, list[2]);
		root.left.addLeftNode(root.left, list[3]);
		root.left.addRightNode(root.left, list[4]);
		root.right.addLeftNode(root.right, list[5]);
		root.right.addRightNode(root.right, list[6]);
		root.left.left.addLeftNode(root.left.left, list[7]);

		System.out.println("���нڵ����: " + root.getNodeNum(root));
		System.out.println("���������: " + root.getDepth(root)); // ��Ϊ��1��
		int k = 4;
		System.out.println("��"+k+"��ڵ����: " + root.getKthLevelNumber(root, 4));
		System.out.println("Ҷ�ӽڵ����: " + root.getLeafNumber(root));
		
		BinaryTree r1 = new BinaryTree(1);
		r1.addLeftNode(r1, 12);
		r1.addRightNode(r1, 13);
		
		BinaryTree r2 = new BinaryTree(2);
		r2.addLeftNode(r2, 22);
		r2.addLeftNode(r2.left, 23);
		System.out.println("�������Ƿ�ͬ��: " + root.cmpStructure(r1, r2));

		System.out.println("�Ƿ�AVL��: "+r1.isAVL(r2));

		// ������
		Traversal traversal = new Traversal();

		System.out.print("ǰ�����: ");
		traversal.preTraversal(root);// ǰ�����
		System.out.println("\n=====================");

		System.out.print("�������: ");
		traversal.inTraversal(root);
		System.out.println("\n=====================");

		System.out.print("�������: ");
		traversal.postTraversal(root);
		System.out.println("\n=====================");

		System.out.print("��α���: ");
		traversal.layerTraversal(root);
		System.out.println("\n=====================");
		
		System.out.println("�������ؽ�");
		int[] preOrder = {11, 2, 4, 8, 5, 3, 6, 7};
		int[] inOrder = {8, 4, 2, 5, 11, 6, 3, 7};
		BinaryTree temp = root.rebuildBTree(preOrder, inOrder, preOrder.length);
		traversal.layerTraversal(temp);
	}
}