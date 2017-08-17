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
	 * 冒泡排序
	 * 
	 * 从左向右，依次比较两个相邻元素的大小，如果左边大，则交换两个元素的位置，否则不变，这样一趟结束后，最大元素在数组最右边；
	 * 重复此过程，直至数组有序。
	 */
	public int[] bubbleSort(int[] list) {
		int[] array = copyArray(list);
		for (int i = 0; i < array.length - 1; i++) {
			for (int k = 0; k < array.length - 1 - i; ++k) {
				if (array[k] > array[k + 1]) {// 比较相邻两个元素
					int temp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * 鸡尾酒排序，也叫定向冒泡排序，是冒泡排序的一种改进。
	 * 
	 * 此算法与冒泡排序的不同处在于从低到高然后从高到低，而冒泡排序则仅从低到高去比较序列里的每个元素。 他可以得到比冒泡排序稍微好一点的效能。
	 * 
	 */
	public int[] cocktailSort(int[] list) {
		int[] array = copyArray(list);
		int left = 0, right = array.length - 1;
		while (left < right) {
			for (int i = left; i < right; ++i) { // 前半轮，将最大元素放到后面
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			--right;
			for (int i = right; i > left; --i) { // 后半轮，将最小元素放到前面
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
	 * 选择排序
	 * 
	 * 遍历数组尚未排序部分，选择最小(大)的放在数组开头，然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，
	 * 直到所有元素均排序完毕。
	 * 
	 * 选择排序是不稳定的排序算法，不稳定发生在最小元素与A[i]交换的时刻。 比如序列：{ 5, 8, 5, 2, 9}
	 * 一次选择的最小元素是2，然后把2和第一个5进行交换，从而改变了两个元素5的相对次序。
	 */
	public int[] selectionSort(int[] list) {
		int[] array = copyArray(list);

		for (int i = 0; i < array.length - 1; ++i) {
			int min = array[i];
			int k = i + 1;
			int index = i;
			for (; k < array.length; ++k) {// 从未排序数组中找到最小的
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
	 * 插入排序 对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。
	 * 
	 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，
	 * 为最新元素提供插入空间。
	 * 
	 * 1. 从第一个元素开始，该元素可以认为已经被排序; 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描; 3.
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 5.
	 * 将新元素插入到该位置后, 重复步骤2~5
	 */
	public int[] insertionSort(int[] list) {
		int[] array = copyArray(list);

		for (int i = 1; i < array.length; ++i) {
			int k = i - 1;
			int temp = array[i];

			// 从后向前扫描已排序部分，给array[i]选一个合适的位置,0 ~ i-1 已经从小到大排好序
			while (k >= 0 && temp < array[k]) {
				array[k + 1] = array[k];
				k = k - 1;
			}
			array[k + 1] = temp; // 直到该手牌比抓到的牌小(或二者相等),将抓到的牌插入到该手牌右边(相等元素的相对次序未变,所以插入排序是稳定的)
		}
		return array;
	}

}
