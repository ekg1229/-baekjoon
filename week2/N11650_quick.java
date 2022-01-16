package week2;
import java.util.*;

public class N11650_quick {
	public void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//수의 개수
		int[] arr1 = new int[n];	//n크기의 배열 선언
		int[] arr2 = new int[n];	//n크기의 배열 선언
		
		for(int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();	//배열에 순서대로 데이터 입력
			arr2[i] = sc.nextInt();	//배열에 순서대로 데이터 입력
		}
        
        Quick quick = new Quick();
        quick.sort(arr1, 0, arr1.length - 1);
        quick.sort(arr2, 0, arr2.length - 1);
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+ " ");
            System.out.println(arr2[i]+ " ");
        }
    }
}