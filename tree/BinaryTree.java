package tree;

//������
public class BinaryTree {
	int value = 0;
	BinaryTree left = null;
	BinaryTree right = null;

	// ���캯��
	public BinaryTree(int val) {
		this.value = val;
	}

	/**
	 * �������еĽڵ����
	 * 
	 * �ݹ�ⷨ�� ��1�����������Ϊ�գ��ڵ����Ϊ0 ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� + �������ڵ���� + 1
	 */
	public int getNodeNum(BinaryTree tree) {
		if (tree == null) {
			return 0;
		}
		return getNodeNum(tree.left) + getNodeNum(tree.right) + 1;// �ݹ�������������Ľڵ����������ټ�1�����ڵ㣩
	}

	/**
	 * �������ĸ߶ȡ���ȣ�������--����Ϊ0
	 * 
	 * �ݹ�ⷨ�� (1)�������Ϊ0 (2)�����������Ϊ�գ���ô���=max(��������ȣ����������)+1
	 */
	public int getDepth(BinaryTree root) {
		if (root == null)
			return 0;
		int depthLeft = getDepth(root.left);
		int depthRight = getDepth(root.right);
		return (depthLeft > depthRight) ? (depthLeft + 1) : (depthRight + 1);
	}

	// ��һ������������뵽����������������
	public BinaryTree addLeftNode(BinaryTree tree, int value) {
		if (tree.left == null)
			tree.left = new BinaryTree(value);
		else
			System.out.println("��������Ϊ�գ����ʧ�ܡ�");
		return tree;
	}

	// ��ӵ���������
	public BinaryTree addRightNode(BinaryTree tree, int value) {
		if (tree.right == null) {
			tree.right = new BinaryTree(value);
		} else {
			System.out.println("��������Ϊ�գ����ʧ�ܡ�");
		}
		return tree;
	}

	// ���ݸ�����һ������������һ�Ŷ�����
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
	 * ��ȡ��k��ڵ�ĸ���
	 * 
	 * �ݹ�ⷨ�� ��1�����������Ϊ�ջ���k<1����0 ��2�������������Ϊ�ղ���k==1������1
	 * ��3�������������Ϊ����k>1��������������k-1��Ľڵ������������k-1��ڵ����֮��
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
	 * ���������Ҷ�ӽڵ�ĸ���
	 * 
	 * �ݹ�ⷨ�� ��1�����������Ϊ�գ�����0 ��2�������������Ϊ������������Ϊ�գ�����1
	 * ��3�������������Ϊ�գ�������������ͬʱΪ�գ�������������Ҷ�ӽڵ����������������Ҷ�ӽڵ����
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
	 * �ж����ö������Ƿ�ṹ��ͬ�� �����ǽڵ��value
	 * 
	 * �������������ݡ��ṹ��ͬ��ζ�Ŷ�Ӧ���������Ͷ�Ӧ�����������ṹ��ͬ�� �ݹ�ⷨ�� ��1��������ö�������Ϊ�գ�������
	 * ��2��������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ� ��3��������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ�
	 */

	public boolean cmpStructure(BinaryTree root1, BinaryTree root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}

		boolean leftFlag = cmpStructure(root1.left, root2.left); // �Ƚ��������Ƿ�ͬ��
		boolean rightFlag = cmpStructure(root1.right, root2.right); // �Ƚ��������Ƿ�ͬ��
		return (leftFlag && rightFlag);

	}

	/**
	 * �ж϶������ǲ���ƽ�������
	 * 
	 * �ݹ�ⷨ�� ��1�����������Ϊ�գ�������
	 * ��2�������������Ϊ�գ����������������������AVL���������������������߶�������1�������棬�������ؼ�
	 */
	public boolean isAVL(BinaryTree root) {
		if (root == null) {
			return true;
		}
		int leftHeight = root.getDepth(root.left); // �������ĸ߶�
		int rightHeight = root.getDepth(root.right); // �������ĸ߶�

		boolean LFlag = isAVL(root.left); // �������Ƿ�Ϊƽ����
		boolean RFlag = isAVL(root.right); // �������Ƿ�ΪAVL��
		int difHeight = Math.abs(leftHeight - rightHeight); // ���������ĸ߶Ȳ�
		if (LFlag && RFlag && (difHeight <= 1)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * ��������ľ��� �ݹ�ⷨ�� ��1�����������Ϊ�գ����ؿ� ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻���������������
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
	 * ��ǰ��������к�������������ؽ�������
	 * 
	 * ������ǰ����������У���һ��Ԫ���������ĸ��ڵ��ֵ��������������У��������Ľڵ��ֵλ�ڸ��ڵ��ֵ����ߣ��������Ľڵ��ֵλ �ڸ��ڵ��ֵ���ұߡ�
	 * �ݹ�ⷨ�� ��1�����ǰ�����Ϊ�ջ��������Ϊ�ջ�ڵ����С�ڵ���0������NULL��
	 * ��2���������ڵ㡣ǰ������ĵ�һ�����ݾ��Ǹ��ڵ�����ݣ�������������ҵ����ڵ��λ�ã��ɷֱ��֪����������������ǰ��������
	 * �����У��ؽ�����������
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

		// �ҳ����ڵ���������������е��±����� rootIndex
		// ��������������У��±�Ϊ 0 ~ rootIndex -1 Ϊ����������
		// rootIndex + 1 ~ inOrder.length - 1 Ϊ����������
		int rootIndex = 0;
		for (int i = 0; i < nodeNum; ++i) {
			if (root.value == inOrder[i]) {
				rootIndex = i;
				System.out.println(rootIndex);
				break;
			}
		}

		// �ؽ�������
		int[] preLeft = new int[rootIndex];
		System.arraycopy(preOrder, 1, preLeft, 0, rootIndex); // ��������
		int[] inLeft = new int[rootIndex];
		System.arraycopy(inOrder, 0, inLeft, 0, rootIndex);
		root.left = rebuildBTree(preLeft, inLeft, rootIndex); // �ؽ�������

		// �ؽ�������
		int[] preRight = new int[nodeNum - rootIndex - 1];
		System.arraycopy(preOrder, rootIndex + 1, preRight, 0, nodeNum - rootIndex - 1);		
		int[] inRight = new int[nodeNum - rootIndex - 1];
		System.arraycopy(inOrder, rootIndex + 1, inRight, 0, nodeNum - rootIndex - 1);
		root.right = rebuildBTree(preRight, inRight, nodeNum - rootIndex - 1); // �ؽ�������

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

// �������ľ���
class Solution {
	public void Mirror(BinaryTree root) {
		if (root == null)
			return;
		BinaryTree temp = root.left;
		root.left = root.right;// ������������
		root.right = temp;
		Mirror(root.left);// �ݹ龵��������
		Mirror(root.right);// �ݹ龵��������
	}
}
