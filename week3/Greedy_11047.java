package week3;
import java.util.*;

/* 
 * 1. K원을 만들 때 최소한의 개수를 이용해야 함
 * 	  => 가장 큰 가치를 가진 동전부터 선택
 * 결론: N개의 동전 중 가장 큰 가치를 지닌 동전부터 탐색.. 동전의 가치가 K보다 작거나 같은 경우의 수를 더하면 됨
 */

public class Greedy_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		
		for(int i = N - 1; i >= 0; i--) {
			if(coin[i] <= K) {// 현재 동전의 가치가 K보다 작거나 같을 때
				count += (K / coin[i]);// 현재 가치의 동전으로 구성할 수 있는 개수의 총합
				K = K % coin[i];
			}
		}
		System.out.println(count);
	}
}