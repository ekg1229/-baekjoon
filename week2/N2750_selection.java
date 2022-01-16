package week2;
import java.util.*;

public class N2750_selection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//수의 개수
		int[] arr = new int[n];	//n크기의 배열 선언
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();	//배열에 순서대로 데이터 입력
		}

	    // Selection sort(Ascending)
	    for (int i = 0; i < n; i++) {
	        for (int j = i + 1; j < n; j++) {
	            if (arr[j] < arr[i]) {
	                int temp = arr[j];
	                arr[j] = arr[i];
	                arr[i] = temp;
	            }
	        }
	    }

	    for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);	//배열 출력
		}
	}
}