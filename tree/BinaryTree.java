package tree;

//二叉树
public class BinaryTree {
	int value = 0;
	BinaryTree left = null;
	BinaryTree right = null;

	// 构造函数
	public BinaryTree(int val) {
		this.value = val;
	}

	/**
	 * 计算树中的节点个数
	 * 
	 * 递归解法： （1）如果二叉树为空，节点个数为0 （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
	 */
	public int getNodeNum(BinaryTree tree) {
		if (tree == null) {
			return 0;
		}
		return getNodeNum(tree.left) + getNodeNum(tree.right) + 1;// 递归计算左、右子树的节点个数，最后再加1（根节点）
	}

	/**
	 * 计算树的高度、深度（层数）--空树为0
	 * 
	 * 递归解法： (1)空树深度为0 (2)如果二叉树不为空，那么深度=max(左子树深度，右子树深度)+1
	 */
	public int getDepth(BinaryTree root) {
		if (root == null)
			return 0;
		int depthLeft = getDepth(root.left);
		int depthRight = getDepth(root.right);
		return (depthLeft > depthRight) ? (depthLeft + 1) : (depthRight + 1);
	}

	// 给一个数，将其加入到二叉树的左子树中
	public BinaryTree addLeftNode(BinaryTree tree, int value) {
		if (tree.left == null)
			tree.left = new BinaryTree(value);
		else
			System.out.println("左子树不为空，添加失败。");
		return tree;
	}

	// 添加到右子树中
	public BinaryTree addRightNode(BinaryTree tree, int value) {
		if (tree.right == null) {
			tree.right = new BinaryTree(value);
		} else {
			System.out.println("右子树不为空，添加失败。");
		}
		return tree;
	}

	// 根据给定的一个数组来建立一颗二叉树
	public static void initializeBTree(BinaryTree root, int[] list, int index) {
		if (index < list.length) {
			root.value = list[index];
		} else {
			return;
		}
		initializeBTree(root.left, list, index * 2 + 1);
		initializeBTree(root.right, list, index * 2 + 2);
	}

	/**
	 * 获取第k层节点的个数
	 * 
	 * 递归解法： （1）如果二叉树为空或者k<1返回0 （2）如果二叉树不为空并且k==1，返回1
	 * （3）如果二叉树不为空且k>1，返回左子树中k-1层的节点个数与右子树k-1层节点个数之和
	 * 
	 */
	public int getKthLevelNumber(BinaryTree root, int k) {
		if (root == null || k < 1) {
			return 0;
		} else if (k == 1) {
			return 1;
		}
		int leftNumber = getKthLevelNumber(root.left, k - 1);
		int rightNumber = getKthLevelNumber(root.right, k - 1);
		return (leftNumber + rightNumber);
	}

	/**
	 * 求二叉树中叶子节点的个数
	 * 
	 * 递归解法： （1）如果二叉树为空，返回0 （2）如果二叉树不为空且左右子树为空，返回1
	 * （3）如果二叉树不为空，且左右子树不同时为空，返回左子树中叶子节点个数加上右子树中叶子节点个数
	 * 
	 */
	public int getLeafNumber(BinaryTree root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int leftNum = getLeafNumber(root.left);
		int rightNum = getLeafNumber(root.right);
		return (leftNum + rightNum);
	}

	/**
	 * 判断两棵二叉树是否结构相同， 不考虑节点的value
	 * 
	 * 不考虑数据内容。结构相同意味着对应的左子树和对应的右子树都结构相同。 递归解法： （1）如果两棵二叉树都为空，返回真
	 * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假 （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
	 */

	public boolean cmpStructure(BinaryTree root1, BinaryTree root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}

		boolean leftFlag = cmpStructure(root1.left, root2.left); // 比较左子树是否同构
		boolean rightFlag = cmpStructure(root1.right, root2.right); // 比较右子树是否同构
		return (leftFlag && rightFlag);

	}

	/**
	 * 判断二叉树是不是平衡二叉树
	 * 
	 * 递归解法： （1）如果二叉树为空，返回真
	 * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
	 */
	public boolean isAVL(BinaryTree root) {
		if (root == null) {
			return true;
		}
		int leftHeight = root.getDepth(root.left); // 左子树的高度
		int rightHeight = root.getDepth(root.right); // 右子树的高度

		boolean LFlag = isAVL(root.left); // 左子树是否为平衡树
		boolean RFlag = isAVL(root.right); // 右子树是否为AVL树
		int difHeight = Math.abs(leftHeight - rightHeight); // 左右子树的高度差
		if (LFlag && RFlag && (difHeight <= 1)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 求二叉树的镜像 递归解法： （1）如果二叉树为空，返回空 （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
	 */
	public BinaryTree mirror(BinaryTree root) {
		if (root == null) {
			return null;
		}
		BinaryTree pLeft = mirror(root.left);
		BinaryTree pRight = mirror(root.right);

		root.left = pRight;
		root.right = pLeft;
		return root;
	}

	/**
	 * 由前序遍历序列和中序遍历序列重建二叉树
	 * 
	 * 二叉树前序遍历序列中，第一个元素总是树的根节点的值。中序遍历序列中，左子树的节点的值位于根节点的值的左边，右子树的节点的值位 于根节点的值的右边。
	 * 递归解法： （1）如果前序遍历为空或中序遍历为空或节点个数小于等于0，返回NULL。
	 * （2）创建根节点。前序遍历的第一个数据就是根节点的数据，在中序遍历中找到根节点的位置，可分别得知左子树和右子树的前序和中序遍
	 * 历序列，重建左右子树。
	 */
	public BinaryTree rebuildBTree(int[] preOrder, int[] inOrder, int nodeNum) {
		if (preOrder == null || inOrder == null || nodeNum < 0) {
			return null;
		}
		
		BinaryTree root = new BinaryTree(0);
		root.value = preOrder[0];
		if (nodeNum == 1){
			return root;
		}

		// 找出根节点在中序遍历数组中的下标索引 rootIndex
		// 在中序遍历数组中，下标为 0 ~ rootIndex -1 为左子树部分
		// rootIndex + 1 ~ inOrder.length - 1 为右子树部分
		int rootIndex = 0;
		for (int i = 0; i < nodeNum; ++i) {
			if (root.value == inOrder[i]) {
				rootIndex = i;
				System.out.println(rootIndex);
				break;
			}
		}

		// 重建左子树
		int[] preLeft = new int[rootIndex];
		System.arraycopy(preOrder, 1, preLeft, 0, rootIndex); // 复制数组
		int[] inLeft = new int[rootIndex];
		System.arraycopy(inOrder, 0, inLeft, 0, rootIndex);
		root.left = rebuildBTree(preLeft, inLeft, rootIndex); // 重建左子树

		// 重建右子树
		int[] preRight = new int[nodeNum - rootIndex - 1];
		System.arraycopy(preOrder, rootIndex + 1, preRight, 0, nodeNum - rootIndex - 1);		
		int[] inRight = new int[nodeNum - rootIndex - 1];
		System.arraycopy(inOrder, rootIndex + 1, inRight, 0, nodeNum - rootIndex - 1);
		root.right = rebuildBTree(preRight, inRight, nodeNum - rootIndex - 1); // 重建右子树

		return root;
	}

	public static void printArray(int[] list) {
		for (int i = 0; i < list.length; ++i) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] list = { 1, 2, 3, 4, 5 };
		BinaryTree root = new BinaryTree(0);

		initializeBTree(root, list, 0);

		System.out.println(root.getNodeNum(root));
		System.out.println(root.value);
	}

}

// 二叉树的镜像
class Solution {
	public void Mirror(BinaryTree root) {
		if (root == null)
			return;
		BinaryTree temp = root.left;
		root.left = root.right;// 交换左右子树
		root.right = temp;
		Mirror(root.left);// 递归镜像左子树
		Mirror(root.right);// 递归镜像右子树
	}
}
