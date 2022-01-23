package week3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 부분 합을 이용한 완전 탐색, DP
 * dp[i][j] = min(dp[i-1], dp[i][j-1], dp[i-1][j-1])
 * 특정 게임판의 숫자가 1인 경우, 그 게임판의 왼쪽, 위쪽, 왼쪽 대각선의 저장된 숫자 중 가장 작은 값에 1을 더한 값을 dp에 저장.
 * 만약에 특정 게임판의 숫자에 대하여 세 가지 방향 중 0이 존재한다면, 가능한 최대 사각형은 1x1
 * 세 가지 방향 중 가장 작은 값이 1이라면, 가능한 최대 사각형은 2x2
 * 단, dp[1][1] = arr[1][1] 왜냐하면 첫 시작점은 세 가지 방향을 따질 수 없기 때문.
 */

public class DP_1915 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//전체 게임판의 크기가 1 x 1인 경우는 1을 출력하고 종료.
		if (N == 1 && M == 1) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int ans = 0;

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split("");

			for (int j = 1; j <= M; j++) {
				int temp = Integer.parseInt(input[j - 1]);

				if (i == 1 && j == 1) { // 맨 처음 게임판의 숫자는 그대로 dp[i][j]에 저장.
					dp[i][j] = temp;
				}
				else { // (1, 2) 부터는 왼쪽, 위쪽, 왼쪽 대각선 방향 중 가장 작은 값에 1을 더한 값을 dp[i][j]에 저장.
					if (temp == 1) {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
						ans = Math.max(ans, dp[i][j]);
					}
				}
			}
		}
		bw.write(ans * ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}