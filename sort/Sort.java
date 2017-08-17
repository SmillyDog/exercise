package sort;

public class Sort {

	public static int[] copyArray(int[] list) {
		int[] array = new int[list.length];
		for (int i = 0; i < array.length; ++i) {
			array[i] = list[i];
		}
		return array;
	}

	/**
	 * ð������
	 * 
	 * �������ң����αȽ���������Ԫ�صĴ�С�������ߴ��򽻻�����Ԫ�ص�λ�ã����򲻱䣬����һ�˽��������Ԫ�����������ұߣ�
	 * �ظ��˹��̣�ֱ����������
	 */
	public int[] bubbleSort(int[] list) {
		int[] array = copyArray(list);
		for (int i = 0; i < array.length - 1; i++) {
			for (int k = 0; k < array.length - 1 - i; ++k) {
				if (array[k] > array[k + 1]) {// �Ƚ���������Ԫ��
					int temp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * ��β������Ҳ�ж���ð��������ð�������һ�ָĽ���
	 * 
	 * ���㷨��ð������Ĳ�ͬ�����ڴӵ͵���Ȼ��Ӹߵ��ͣ���ð����������ӵ͵���ȥ�Ƚ��������ÿ��Ԫ�ء� �����Եõ���ð��������΢��һ���Ч�ܡ�
	 * 
	 */
	public int[] cocktailSort(int[] list) {
		int[] array = copyArray(list);
		int left = 0, right = array.length - 1;
		while (left < right) {
			for (int i = left; i < right; ++i) { // ǰ���֣������Ԫ�طŵ�����
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			--right;
			for (int i = right; i > left; --i) { // ����֣�����СԪ�طŵ�ǰ��
				if (array[i - 1] > array[i]) {
					int temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
				}
			}
			++left;
		}

		return array;
	}

	/**
	 * ѡ������
	 * 
	 * ����������δ���򲿷֣�ѡ����С(��)�ķ������鿪ͷ��Ȼ���ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ��ŵ����������е�ĩβ���Դ����ƣ�
	 * ֱ������Ԫ�ؾ�������ϡ�
	 * 
	 * ѡ�������ǲ��ȶ��������㷨�����ȶ���������СԪ����A[i]������ʱ�̡� �������У�{ 5, 8, 5, 2, 9}
	 * һ��ѡ�����СԪ����2��Ȼ���2�͵�һ��5���н������Ӷ��ı�������Ԫ��5����Դ���
	 */
	public int[] selectionSort(int[] list) {
		int[] array = copyArray(list);

		for (int i = 0; i < array.length - 1; ++i) {
			int min = array[i];
			int k = i + 1;
			int index = i;
			for (; k < array.length; ++k) {// ��δ�����������ҵ���С��
				if (min > array[k]) {
					min = array[k];
					index = k;
				}
			}
			array[index] = array[i];
			array[i] = min;
		}
		return array;
	}

	/**
	 * �������� ����δ��������(����ץ������)��������������(�����Ѿ��ź��������)�дӺ���ǰɨ�裬�ҵ���Ӧλ�ò����롣
	 * 
	 * ����������ʵ���ϣ�ͨ������in-place���򣨼�ֻ���õ�O(1)�Ķ���ռ�����򣩣�����ڴӺ���ǰɨ������У���Ҫ������������Ԫ�������Ųλ��
	 * Ϊ����Ԫ���ṩ����ռ䡣
	 * 
	 * 1. �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������; 2. ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��; 3.
	 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�� 4. �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�� 5.
	 * ����Ԫ�ز��뵽��λ�ú�, �ظ�����2~5
	 */
	public int[] insertionSort(int[] list) {
		int[] array = copyArray(list);

		for (int i = 1; i < array.length; ++i) {
			int k = i - 1;
			int temp = array[i];

			// �Ӻ���ǰɨ�������򲿷֣���array[i]ѡһ�����ʵ�λ��,0 ~ i-1 �Ѿ���С�����ź���
			while (k >= 0 && temp < array[k]) {
				array[k + 1] = array[k];
				k = k - 1;
			}
			array[k + 1] = temp; // ֱ�������Ʊ�ץ������С(��������),��ץ�����Ʋ��뵽�������ұ�(���Ԫ�ص���Դ���δ��,���Բ����������ȶ���)
		}
		return array;
	}

}
