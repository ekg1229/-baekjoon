package week3;
import java.util.*;

/* 
 * 1. max보다 크면 max를 해당 값으로 갱신
 * 2. max값보다 작으면 리턴할 변수 = max-해당 값;
 */

public class Greedy_11501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans[] = new long[n];
		
		for(int i = 0 ; i < n ; i++ ) {
			int days = sc.nextInt();
			long stocks[] = new long[days];
			long max = 0;
			for(int j = 0 ; j < days ; j++ ) {
				stocks[j] = sc.nextInt();
			}
			for(int j = days-1 ; j >= 0 ; j-- ) {
				if(stocks[j] > max) {
					max = stocks[j];
				} else {
					ans[i] += (max - stocks[j]);
				}
			}		
		}
		
		for(long i : ans) {
			System.out.println(i);
		}
	}
}