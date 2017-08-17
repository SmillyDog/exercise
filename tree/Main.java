package tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = { 11, 2, 3, 4, 5, 6, 7, 8 };
		BinaryTree root = new BinaryTree(list[0]); // 二叉树类
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

		System.out.println("所有节点个数: " + root.getNodeNum(root));
		System.out.println("二叉树深度: " + root.getDepth(root)); // 根为第1层
		int k = 4;
		System.out.println("第"+k+"层节点个数: " + root.getKthLevelNumber(root, 4));
		System.out.println("叶子节点个数: " + root.getLeafNumber(root));
		
		BinaryTree r1 = new BinaryTree(1);
		r1.addLeftNode(r1, 12);
		r1.addRightNode(r1, 13);
		
		BinaryTree r2 = new BinaryTree(2);
		r2.addLeftNode(r2, 22);
		r2.addLeftNode(r2.left, 23);
		System.out.println("两个树是否同构: " + root.cmpStructure(r1, r2));

		System.out.println("是否AVL树: "+r1.isAVL(r2));

		// 遍历类
		Traversal traversal = new Traversal();

		System.out.print("前序遍历: ");
		traversal.preTraversal(root);// 前序遍历
		System.out.println("\n=====================");

		System.out.print("中序遍历: ");
		traversal.inTraversal(root);
		System.out.println("\n=====================");

		System.out.print("后序遍历: ");
		traversal.postTraversal(root);
		System.out.println("\n=====================");

		System.out.print("层次遍历: ");
		traversal.layerTraversal(root);
		System.out.println("\n=====================");
		
		System.out.println("二叉树重建");
		int[] preOrder = {11, 2, 4, 8, 5, 3, 6, 7};
		int[] inOrder = {8, 4, 2, 5, 11, 6, 3, 7};
		BinaryTree temp = root.rebuildBTree(preOrder, inOrder, preOrder.length);
		traversal.layerTraversal(temp);
	}
}