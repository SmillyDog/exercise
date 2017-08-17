package classics;

import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map;

/**
 * 单调栈：满足从栈顶到栈底，由大到小的顺序
 *
 * 适用问题： 分别求一个数组中位置 i(i∈[0, length-1]) 上的数在左、右方向上比它小的离它最近的数。 注意：数组不能有重复元素
 * 
 */
class NearestMin {
	int left; // 左边比它小的最近的数
	int right; // 右边比它小的最近的数

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
		stack.push(array[0]); // 数组的第一个元素先入栈
		int top = stack.peek(); // 栈顶元素

//		System.out.print("push:" + top + "  ,栈中元素(栈顶-->栈底): ");
//		stack = printStack(stack);

		for (int i = 1; i < array.length; ++i) {
			if (array[i] > top) { // 大于栈顶元素，直接入栈，不会破坏单调栈的结构
				stack.push(array[i]);

//				System.out.print("push:" + array[i] + ", 栈中元素个数: " + stack.size() + "  ,栈中元素(栈顶-->栈底): ");
//				stack = printStack(stack);

				top = array[i]; // 更新栈顶元素

			} else { // 小于栈顶元素，将栈顶元素出栈，在最近最小数组中插入一条记录，依次进行直到大于栈顶元素，再将array[i]入栈
				top = stack.peek(); // 更新栈顶元素
				while (array[i] < top && !stack.empty()) { // array[i]
															// 就是右边比它最小的且距离最近的元素					
					top = stack.pop();
					
					
//					System.out.println("====top: " + top + ",  array[" + i + "]: " + array[i]);
//
//					System.out.print("pop:" + top + ", 栈中元素个数: " + stack.size() + "  ,栈中元素(栈顶-->栈底): ");
//					stack = printStack(stack);

					if (stack.empty()) {
						map.put(top, new NearestMin(0, array[i])); // 栈为空，则左边没有比它小的
						continue;
					} else {
						map.put(top, new NearestMin(stack.peek(), array[i])); // 它的下一个元素就是左边比它小的又离得最近的元素
					}
					top = stack.peek(); // 出栈操作后，再次更新栈顶元素
				}
				stack.push(array[i]); // 为array[i]找到合适位置，入栈
				top = stack.peek(); // 更新栈顶元素

//				System.out.print("push:" + array[i] + ", 栈中元素个数: " + stack.size() + "  ,栈中元素(栈顶-->栈底): ");
//				stack = printStack(stack);
			}
		}

		// 遍历结束后，清算栈中剩余的元素
		while (!stack.empty()) {
			top = stack.pop();
			
//			System.out.print("pop:" + top + ", 栈中元素个数: " + stack.size() + "  ,栈中元素(栈顶-->栈底): ");
//			stack = printStack(stack);

			if (stack.empty()) {
				map.put(top, new NearestMin(0, 0));
			} else {
				map.put(top, new NearestMin(stack.peek(), 0)); // 右边没有比它小的
			}

		}

		return map;
	}

	// 打印HashMap
	public static void printMap(TreeMap<Integer, NearestMin> map) {
		Iterator<Map.Entry<Integer, NearestMin>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, NearestMin> entry = (Map.Entry<Integer, NearestMin>) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + ": " + value);
		}

	}

	// 从栈顶到栈底，打印栈中元素
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
				System.out.println(top); // 栈底
			} else {
				System.out.print(top + " ");
			}
			list[j++] = top; // list从左到右，栈顶到栈底
		}

		for (int i = list.length - 1; i >= 0; --i) {
			stack.push(list[i]); // 从list的尾部开始入栈
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
