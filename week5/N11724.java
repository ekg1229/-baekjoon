package week5;
import java.util.*;
/*
 * 연결 요소의 개수를 찾는 문제
 * 정점의 개수만큼 루프를 돌면서 방문한 적 없는 정점이면 result++ 
 */
public class N11724 {
	static int[][] graph = new int[1001][1001];
	static int V;
	static int E;
	static boolean[] visited = new boolean[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int a,b;
		for(int i = 0; i < E; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			// 간선 연결
			graph[a][b] = graph[b][a] = 1;
		}
		
		int result = 0 ;
		
		// dfs 탐색
		for(int i = 1; i <= V; i++) {
			if(visited[i] == false) { // 방문한 적 없는 노드라면 dfs
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		
		sc.close();
		return;
	}

	public static void dfs(int index) {
		if(visited[index] == true)
			return;
		else {
			visited[index] = true;
			for(int i = 1; i <= V; i++) {
				if(graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}
