package week3;
import java.util.*;

/* case1: 자신의 왼쪽 대각선에 존재하는 값 다음에 올 수 있음
 * dp[i][0] = max(dp[i-1][1], dp[i-2][1]) + arr[i][0]
 * 
 * case2: 자신의 왼쪽, 왼쪽에 위치한 값 다음에 올 수 있음
 * dp[i][1] = max(dp[i-1][0], dp[i-2][0] + arr[i][1]
 */

public class DP_9465 {
	static int dp[][] ,cost[][] ;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n= sc.nextInt();
			
            //입력되는 n값에 따라 배열을 선언
			cost = new int[2][n+1];
			dp = new int[2][n+1];
			
			for(int j=0; j<2; j++) { //비용 입력
				for(int k=1; k<=n; k++) {
					cost[j][k] = sc.nextInt();
				}
			}
			
            // 0번째, 1번째 행의 첫 번째 열이 초기화로 초기값이 된다.
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			for(int k=2; k<=n; k++) { //열 반복을 통해 0번과 1번행을 동시 처리
				dp[0][k] = Math.max( dp[1][k-1], dp[1][k-2])+cost[0][k];
				dp[1][k] = Math.max(dp[0][k-1],dp[0][k-2])+cost[1][k];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n])); // n번째 열의 최댓값을 반환 후 출력
		}
	}
}