package sort;

/**
 * 快速排序<br/>
 * 
 * 1) i = L, j = R, 将基准数挖出形成第一个坑a[i]：key = a[i]<br/>
 * 2) j--，由后向前找比它key小的数，挖出填到前一个坑a[i]中<br/>
 * 3) i++, 右前向后找比它key大的数，挖出填到前一个坑a[j]中<br/>
 * 4) 再重复2) 3)步，直到i==j, 将基准数key填入到a[i]中<br/>
 */
public class QuickSort {

	public static void qSort(int[] array, int low, int high) {
		if (low >= high) { /*如果左边索引大于或者等于右边的索引就代表已经整理完成一个组了*/
			return;
		}
		
		int first = low, last = high;
		int key = array[first]; // 将比key小的放在其左边，比它大的放在右边

		while (first < last) {
			while (first < last && array[last] > key) { // 由后向前, 找比key小的数, 填到前一个坑array[first]
				--last;
			}
			array[first] = array[last];
			
			while(first < last && array[first] < key) { // 右前向后找比它大的数, 填到前一个坑array[last]
				++first;
			}
			array[last] = array[first];			
		}
		array[first] = key; // 基准数记录到位
		qSort(array, low, first - 1); // 递归排序左边的
		qSort(array, first + 1, high); // 递归排序右边的
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {23, 1, 33, 12, 15, 17, 16, 22, 4, 56, 88, 21};
		qSort(array, 0, array.length - 1);
		
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}

	}

}
