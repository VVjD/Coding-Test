package study.java.tree.exploration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1250번, DFS와 BFS
public class DFSandBFS {
	
	static int[][]  graph;
	static int[]  visit;
	static ArrayList<Integer> proc;
	static int N;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer tokenizer;
		
		tokenizer = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken()); //정점의 개수
		int M = Integer.parseInt(tokenizer.nextToken()); //간선의 개수
		int V = Integer.parseInt(tokenizer.nextToken()); //탐색을 시작할 정점의 번호
		//어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
		//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력해라.
		
		graph = new int[N + 1][N + 1];
		visit = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			
			graph[a][b] = graph[b][a] = 1; //연결
			
		}
		
		dfs(V);

		System.out.println();
		
		visit = new int[N + 1];

		bfs(V);
		
	}

	
	
	private static void dfs(int start) throws IOException {

		visit[start] = 1;
		System.out.print(start + " ");
		
		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1 && visit[i] != 1) {
				dfs(i);
			}
		}
		
	}
	
	
	
	private static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visit[start] = 1;
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			
			System.out.print(top + " ");
			
			for (int i = 1; i <= N; i++) {
				if (graph[top][i] == 1 && visit[i] != 1) {
					queue.add(i);
					visit[i] = 1;
				}
			}
		}
	}
	
}
