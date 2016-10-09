import java.util.Scanner;

public class TernarySearch {
	public static int ternarySearch(int[] Arr, int data) {
		return ternarySearch(Arr, data, 0, Arr.length - 1);
	}

	// TernarySearch function 
	public static int ternarySearch(int[] Arr, int data, int start_pt, int end_pt)
	{
		if (start_pt > end_pt)
			return -1;
       // computing 1/3rd of list
		int m1 = start_pt + (end_pt - start_pt) / 3;
       //computing 2/3rd of list
		int m2 = start_pt + 2 * (end_pt - start_pt) / 3;

		if (Arr[m1] == data)
			return m1;
   // search in 1/3rd
		else if (Arr[m2] == data)
			return m2;
   // search in 3/3rd
		else if (data < Arr[m1])
			return ternarySearch(Arr, data, start_pt, m1 - 1);
   // search in 2/3rd
		else if (data > Arr[m2])
			return ternarySearch(Arr, data, m2 + 1, end_pt);

		else
			return ternarySearch(Arr, data, m1, m2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, i;

		System.out.println("Enter total number of array elements");
		n = sc.nextInt();

		int array[] = new int[n];

		System.out.println("\nEnter " + n + " sorted numbers");
		for (i = 0; i < n; i++)
			array[i] = sc.nextInt();
		System.out.println("\nEnter the number to be searched for - ");
		int pos = sc.nextInt();
             // calling ternary search in main mthod
		int result = ternarySearch(array, pos);

		if (result == -1)
			System.out.println("\n" + pos + " Number not found");
		else
			System.out.println("\n" + pos + " Number found at position " + result);

	}
}
