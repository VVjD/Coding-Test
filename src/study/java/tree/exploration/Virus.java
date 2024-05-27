package study.java.tree.exploration;

import java.io.*;
import java.util.*;

//백준 2606번, 바이러스
public class Virus {
	
	static int[][] graph;
	static int[] visit;
	static int N = 0;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		N = Integer.parseInt(reader.readLine()); //컴퓨터 수
		int M = Integer.parseInt(reader.readLine()); //컴퓨터 쌍의 수
		
		graph = new int[N+1][N+1]; //컴퓨터 번호가 1부터 시작해서
        visit = new int[N+1];
        
        for (int i = 0; i < M; i++) {
        	tokenizer = new StringTokenizer(reader.readLine());
        	
        	int a = Integer.parseInt(tokenizer.nextToken()); //시작
            int b = Integer.parseInt(tokenizer.nextToken()); //끝
            
            graph[a][b] = graph[b][a] = 1; //무방향
            
        }
        dfs(1); //1번 컴퓨터 감염
        
        System.out.println(count - 1);//시작점 제외
        
        reader.close();
        
	} //main
	
	

	private static void dfs(int start) {
		
		visit[start] = 1; //바이러스 시작
		count++; //바이러스에 감염된 컴퓨터 수
		
		for (int i = 0; i <= N; i++) {
			if (graph[start][i] == 1 && visit[i] != 1) { //전염된 컴퓨터와 연결되고, 아직 방문하지 않은 경우
				dfs(i); //전염
			}
			
		} //for
		
	} //dfs

}
