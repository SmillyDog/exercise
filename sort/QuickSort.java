package sort;

/**
 * ��������<br/>
 * 
 * 1) i = L, j = R, ����׼���ڳ��γɵ�һ����a[i]��key = a[i]<br/>
 * 2) j--���ɺ���ǰ�ұ���keyС�������ڳ��ǰһ����a[i]��<br/>
 * 3) i++, ��ǰ����ұ���key��������ڳ��ǰһ����a[j]��<br/>
 * 4) ���ظ�2) 3)����ֱ��i==j, ����׼��key���뵽a[i]��<br/>
 */
public class QuickSort {

	public static void qSort(int[] array, int low, int high) {
		if (low >= high) { /*�������������ڻ��ߵ����ұߵ������ʹ����Ѿ��������һ������*/
			return;
		}
		
		int first = low, last = high;
		int key = array[first]; // ����keyС�ķ�������ߣ�������ķ����ұ�

		while (first < last) {
			while (first < last && array[last] > key) { // �ɺ���ǰ, �ұ�keyС����, �ǰһ����array[first]
				--last;
			}
			array[first] = array[last];
			
			while(first < last && array[first] < key) { // ��ǰ����ұ��������, �ǰһ����array[last]
				++first;
			}
			array[last] = array[first];			
		}
		array[first] = key; // ��׼����¼��λ
		qSort(array, low, first - 1); // �ݹ�������ߵ�
		qSort(array, first + 1, high); // �ݹ������ұߵ�
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
