package week3;
import java.util.*;

/* 
 * 1. DNA의 각 자리수를 입력 받으면서 가장 많이 등장한 알파벳과 다른 알파벳이 나온 케이스만큼의 숫자를 hd(hamming distance) 누적해서 더함
 * 2. 위의 과정을 반복하고 마지막에 hd를 출력
 */

public class Greedy_1969 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), max = 0, hd = 0;
		String[] dna = new String[n];
		for(int i = 0; i < n; i++) dna[i] = sc.next();
		for(int i = 0; i < m; i++) {
			int a=0, t=0, g=0, c=0;
			for(int j = 0; j < n; j++) {
				switch(dna[j].charAt(i)) {
				case 'A' : a++; break;
				case 'T' : t++; break;
				case 'G' : g++; break;
				case 'C' : c++; break;
				}
			}
			max = Math.max(a>c?a:c, g>t?g:t);
			hd += (n-max);
			System.out.print(toChar(a, t, g, c, max));
		}
		System.out.println("\n"+hd);
	}
	public static char toChar(int a, int t, int g, int c, int max) {
		if(max==a) return 'A';
		else if(max==c) return 'C';
		else if(max==g) return 'G';
		else return 'T';
	}
}