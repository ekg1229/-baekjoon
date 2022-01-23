package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
 * 1. 동석차가 없으니까 서류 순위를 기준으로 오름차순 정렬
 * 2. 면접 순위로 판단
 */

public class Greedy_1946 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());
 
        while(tc-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int [] a= new int[n+1];
 
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[x] = y;
            }
            
            int cnt = 1; //서류 순위가 1등일 때
            int standard = a[1]; //기준 값,서류 순위 1등인 사람의 면접 순위
            for(int i=2; i<=n; i++) {
                if(standard > a[i]) { //기준 값보다 a[i]의 면접 순위가 낮다면 
                    cnt++;
                    standard = a[i]; //기준 값 a[i]의 면접 순위로 변경
                }
            }
            System.out.println(cnt);
        }
    }
}