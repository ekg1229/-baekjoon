package week3;
import java.util.*;

/* 
 * 1. 각 자릿수 중에 1이 몇 개인지 센다.
 * 2-1. cnt가 K보다 작으면 출력 후 종료
 * 2-2. 그렇지 않으면 n++, result++;
 */

public class Greedy_1052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        while (true) {
            char[] binary = Integer.toBinaryString(n).toCharArray();
            int cnt = 0;

            for (int i = 0; i < binary.length; i++) if (binary[i] == '1') cnt++;

            if (cnt <= K) {
                System.out.println(result);
                break;
            }
            n++;
            result++;
        }
	}
}