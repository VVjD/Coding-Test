package study.java.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1966번
// 큐를 확인하다보면 내가 확인하려는 번호의 위치가 변할텐데 어떻게 다룰지 고민했다. 배열에 넣을까했는데 그려면 큐 문제가 아니기 때문에 그러면 key 역할을 하는 큐를 하나 더 만들면 된다는 사실을 깨달았다.
public class PrinterQueue { //Ex55_Stack.java
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder(); //결과 담을
		
		int caseNum = Integer.parseInt(reader.readLine()); //테스트 케이스의 수
		
		for (int i = 0; i < caseNum; i++) { //테스트 케이스 반복
		
			Queue<Integer> queueKey = new LinkedList<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			
			int N = Integer.parseInt(tokenizer.nextToken()); //문서의 개수
			int M = Integer.parseInt(tokenizer.nextToken()); //현재 위치
			int printNum = 0; //출력된 번호
									
			tokenizer = new StringTokenizer(reader.readLine());
			
			while (tokenizer.hasMoreTokens()) {
				queue.add(Integer.parseInt(tokenizer.nextToken())); //중요도 큐에 넣기
			} //while
			
			for (int j = 0; j < N; j ++) { //Key가 될 큐 생성
				queueKey.add(j);
			}
			
			while (!queue.isEmpty()) {
				
				boolean loop = true;
				int top = queue.poll(); //요소 읽기
				int key = queueKey.poll(); //키 값도 같이 꺼내기
				
				for (int item : queue) {
					
					if (item > top) { //top보다 우선 순위가 높은 항목이 존재하는 경우
						queue.add(top); //가장 뒤에 재배치
						queueKey.add(key);
						
						loop = false;
						break;
					} 
				}
				
				if(loop) { // 우선 순위가 놓은 항목이 존재하지 않는 경우
					printNum ++;
					
					if(key == M) { //확인하려는 위치의 항목인지?
						break;
					} 
				} 
			} //while
			
			builder.append(printNum).append("\n"); //결과 더하기
			
		} //for 
		
		System.out.println(builder);
	} //main
} //PrinterQueue
