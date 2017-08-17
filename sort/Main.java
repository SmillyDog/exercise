package sort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort sort = new Sort();
		int[] array = { 4, 5, 1, 66, 12, 15, 22, 3, 66, 7, 99, 8 };

		System.out.println("======== selection sort ==========");
		printArray(array);
		printArray(sort.selectionSort(array));

		System.out.println("======== bubble sort =============");
		printArray(array);
		printArray(sort.bubbleSort(array));
		
		System.out.println("======== cocktail sort ===========");
		printArray(array);
		printArray(sort.cocktailSort(array));

		System.out.println("======== insertion sort ==========");
		printArray(array);
		printArray(sort.insertionSort(array));

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (i < arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.println(arr[i]);
			}
		}
	}

}
