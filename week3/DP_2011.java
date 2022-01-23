package week3;
import java.util.*;

/* 
 * 1. DP: 인덱스 1부터 사용, dp[i] = input의 i-1번째 문자까지의 암호 해석 경우의 수
 * 2. 예시(25114)
 * 	  dp[1]=1(2)
 * 	  dp[2]=2(2 5, 25)
 * 	  dp[3]=2(2 5 1, 25 1)
 * 	  dp[4]=4(2 5 1 1, 25 1 1, 25 11, 2 5 11)
 * 	  dp[5]=6(2 5 1 1 4, 25 1 1 4, 23 1 14, 25 11 4, 2 5 1 14)
 * 	  => dp[i] = dp[i-2]+dp[i-1]
 * 3. 0인 경우
 * 	  0이나 00이 나오면 잘못된 것으므로 0을 출력 후 프로그램 종료
 * 	  중간에 0이 나오면 prev(i-1, 앞 문자) => prev가 1 또는 2라면 prev에 0을 붙이면 됨
 * 4. 예시(1203)
 * 	  dp[1]=1(1)
 * 	  dp[2]=2(1 2, 12)
 * 	  dp[3]=1(1 20)
 * 	  dp[4]=1(1 20 3)
 * 	  => dp[i] = dp[i-1]
 * 5. 1000000으로 나누기
 * 	  문제에서 1000000으로 나눈 나머지를 출력하라고 했으므로 dp[i]를 받을 때마다 해당 값으로 나눔
 */

public class DP_2011 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		if(s.charAt(0)=='0') { // 시작이 0이면 잘못된 암호
			System.out.println("0");
			return;
		}
		
		long[] dp=new long[s.length()+1];
		dp[0]=dp[1]=1;
		
		for(int i=2;i<=s.length();i++) {
			char ch=s.charAt(i-1); // 현재 체크하는 문자
			char prev=s.charAt(i-2); // 앞 문자
			if(ch=='0') {
				if(prev=='1' || prev=='2') dp[i]=dp[i-2]%1000000; 
				 //현재 문자 0을 앞과 연결할 수 없다면 잘못된 문자열이므로 종료.
				else break;
			}
			else {
				//앞 문자가 0이면 경우의 수 변화 없음
				if(prev=='0') dp[i]=dp[i-1]%1000000;
				else { //앞 문자와 연결할 수 있는지 체크
				 	//앞 문자와 연결했을 때 숫자를 정수형으로 출력
					int temp=(prev-'0')*10+(ch-'0');
					// 암호 코드안에 들어오면 경우의 수 갱신
					if(1<=temp && temp<=26) dp[i]=(dp[i-2]+dp[i-1])%1000000;
					else dp[i]=dp[i-1]%1000000;
				}
			}
		}
		System.out.println(dp[s.length()]%1000000);
	}
}
