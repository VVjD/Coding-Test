package study.java.tree;

import java.io.*;
import java.util.*;

//백준 9372번, 상근이의 여행
public class Travel {
    static int[][] graph;
    static int[] visit;
    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(reader.readLine()); // 테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            N = Integer.parseInt(tokenizer.nextToken()); // 국가의 수
            int M = Integer.parseInt(tokenizer.nextToken()); // 비행기의 종류

            graph = new int[N][N];
            visit = new int[N];

            for (int j = 0; j < M; j++) {
                tokenizer = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                //연결
                graph[a - 1][b - 1] = 1;
                graph[b - 1][a - 1] = 1;
            }

            int count = search();

            writer.write(count + "\n");
        }

        reader.close();
        writer.close();
    }

    private static int search() { //BFS(Breadth-First Search)
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;

        queue.offer(0);

        while (!queue.isEmpty()) {
            int front = queue.poll();

            for (int i = 1; i < N; i++) {
                if (graph[front][i] == 1 && visit[i] == 0) { //연결되어 있고 아직 방문하지 않은 경우
                    count++; //방문 횟수
                    
                    visit[i] = 1; //해당 국가 방문했음을 표시
                    queue.offer(i); //다음 국가 넣기
                }
            }
        }

        return count;
    }
}
