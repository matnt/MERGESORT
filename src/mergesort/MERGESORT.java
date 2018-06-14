package mergesort;

import java.util.Scanner;

public class MERGESORT {
	int n;
	int[] k;
	Scanner in;
	public MERGESORT() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MERGESORT merge = new MERGESORT();
		merge.input();
		merge.printResult();
	}
	
	public void input() {
		in = new Scanner(System.in);
		n = in.nextInt();
		k = new int[n];
		for(int i = 0; i < n; i++) {
			k[i] = in.nextInt();
		}
		mergesort(0, n - 1);
	}
	
	public void merge(int a, int b, int c) {
		int i = a;
		int j = b + 1;
		int[] y = new int[n];
		for(int v = a; v <= c; v++) {
			if(i > b) { // khi chỉ còn 1 mảng duy nhất k[b+1...c]
				y[v] = k[j];
				j++;
			} else if(j > c) { // khi chỉ còn 1 mảng duy nhất k[a...b]
				y[v] = k[i];
				i++;
			} else {
				if(k[i] < k[j]) { // so sánh 2 khóa đầu của 2 mảng, nhỏ hơn thì add vào mảng trung gian y
					y[v] = k[i];
					i++;
				} else {
					y[v] = k[j];
					j++;
				}
			}
			
				
		}
		for(int v = a; v <= c; v++) { // chuyển hết các giá trị của mảng trung gian về mảng ban đầu
			k[v] = y[v];
		}
	}
	
	public void mergesort(int l, int r) {
		if(l < r) {
			int m = (l + r)/2;
			mergesort(l, m);
			mergesort(m + 1, r);
			merge(l, m, r);
		}
	}
	
	public void printResult() {
		for(int i = 0; i < n; i++) {
			System.out.print(k[i] + " ");
		}
	}

}
