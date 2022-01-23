package week3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 최적화 문제: 그리디, DP, 파라메트릭 서치... 이 문제는 DP
 * i=j: dp[i][j] = dp[i-1][j-1] + |남자[i]-여자[i]|
 * i>j: dp[i][j] = min(dp[i][j], d[i-1][j])
 * i<j: dp[i][j] = min(dp[i][j], dp[i][j-1])
 */

public class DP_1727 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] man = new int[n + 1];
			int[] woman = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; ++i) {
				man[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= m; ++i) {
				woman[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(man);
			Arrays.sort(woman);
			
			//dp[i][j] : (1~i)까지의 남자와 (1~j)까지의 여자를 커플 매칭했을때 성격 차이 최소값
			int[][] dp = new int[n + 1][m + 1];
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					//i번 남자와 j번 여자 커플 매칭
					dp[i][j] = dp[i - 1][j - 1] + Math.abs(man[i] - woman[j]);
					//남자가 더 많으면 추가된 i번 남자 솔로
					if (i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
					//여자가 더 많으면 추가된 j번 여자 솔로
					else if (i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
				}
			}
			bw.write(dp[n][m] + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
