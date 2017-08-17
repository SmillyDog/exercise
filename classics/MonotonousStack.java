package classics;

import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map;

/**
 * ����ջ�������ջ����ջ�ף��ɴ�С��˳��
 *
 * �������⣺ �ֱ���һ��������λ�� i(i��[0, length-1]) �ϵ��������ҷ����ϱ���С��������������� ע�⣺���鲻�����ظ�Ԫ��
 * 
 */
class NearestMin {
	int left; // ��߱���С���������
	int right; // �ұ߱���С���������

	public NearestMin(int l, int r) {
		this.left = l;
		this.right = r;
	}

	public String toString() {
		return "left: " + left + ", right:" + right;
	}
}

public class MonotonousStack {

	public static TreeMap<Integer, NearestMin> getNearestMins(int[] array) {
		TreeMap<Integer, NearestMin> map = new TreeMap<Integer, NearestMin>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(array[0]); // ����ĵ�һ��Ԫ������ջ
		int top = stack.peek(); // ջ��Ԫ��

//		System.out.print("push:" + top + "  ,ջ��Ԫ��(ջ��-->ջ��): ");
//		stack = printStack(stack);

		for (int i = 1; i < array.length; ++i) {
			if (array[i] > top) { // ����ջ��Ԫ�أ�ֱ����ջ�������ƻ�����ջ�Ľṹ
				stack.push(array[i]);

//				System.out.print("push:" + array[i] + ", ջ��Ԫ�ظ���: " + stack.size() + "  ,ջ��Ԫ��(ջ��-->ջ��): ");
//				stack = printStack(stack);

				top = array[i]; // ����ջ��Ԫ��

			} else { // С��ջ��Ԫ�أ���ջ��Ԫ�س�ջ���������С�����в���һ����¼�����ν���ֱ������ջ��Ԫ�أ��ٽ�array[i]��ջ
				top = stack.peek(); // ����ջ��Ԫ��
				while (array[i] < top && !stack.empty()) { // array[i]
															// �����ұ߱�����С���Ҿ��������Ԫ��					
					top = stack.pop();
					
					
//					System.out.println("====top: " + top + ",  array[" + i + "]: " + array[i]);
//
//					System.out.print("pop:" + top + ", ջ��Ԫ�ظ���: " + stack.size() + "  ,ջ��Ԫ��(ջ��-->ջ��): ");
//					stack = printStack(stack);

					if (stack.empty()) {
						map.put(top, new NearestMin(0, array[i])); // ջΪ�գ������û�б���С��
						continue;
					} else {
						map.put(top, new NearestMin(stack.peek(), array[i])); // ������һ��Ԫ�ؾ�����߱���С������������Ԫ��
					}
					top = stack.peek(); // ��ջ�������ٴθ���ջ��Ԫ��
				}
				stack.push(array[i]); // Ϊarray[i]�ҵ�����λ�ã���ջ
				top = stack.peek(); // ����ջ��Ԫ��

//				System.out.print("push:" + array[i] + ", ջ��Ԫ�ظ���: " + stack.size() + "  ,ջ��Ԫ��(ջ��-->ջ��): ");
//				stack = printStack(stack);
			}
		}

		// ��������������ջ��ʣ���Ԫ��
		while (!stack.empty()) {
			top = stack.pop();
			
//			System.out.print("pop:" + top + ", ջ��Ԫ�ظ���: " + stack.size() + "  ,ջ��Ԫ��(ջ��-->ջ��): ");
//			stack = printStack(stack);

			if (stack.empty()) {
				map.put(top, new NearestMin(0, 0));
			} else {
				map.put(top, new NearestMin(stack.peek(), 0)); // �ұ�û�б���С��
			}

		}

		return map;
	}

	// ��ӡHashMap
	public static void printMap(TreeMap<Integer, NearestMin> map) {
		Iterator<Map.Entry<Integer, NearestMin>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, NearestMin> entry = (Map.Entry<Integer, NearestMin>) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + ": " + value);
		}

	}

	// ��ջ����ջ�ף���ӡջ��Ԫ��
	public static Stack<Integer> printStack(Stack<Integer> stack) {
		if (stack.empty()) {
			System.out.println("null");
			return stack;
		}

		int[] list = new int[stack.size()];
		int j = 0;
		while (!stack.empty()) {
			int top = stack.pop();
			if (stack.empty()) {
				System.out.println(top); // ջ��
			} else {
				System.out.print(top + " ");
			}
			list[j++] = top; // list�����ң�ջ����ջ��
		}

		for (int i = list.length - 1; i >= 0; --i) {
			stack.push(list[i]); // ��list��β����ʼ��ջ
		}
		return stack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 4, -1, 12, 34, 7, -3, -2 };
		TreeMap<Integer, NearestMin> map = getNearestMins(array);
//		System.out.println();
		printMap(map);

	}

}
