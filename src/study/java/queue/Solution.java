package study.java.queue;

import java.util.Collections;
import java.util.PriorityQueue;

//프로그래머스, 프로세스
public class Solution {

	public int solution(int[] priorities, int locations) {
		
		//Priority Queue : 우선순위를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조
		//높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		int answer = 0; // 출력된 번호
		
		for (int i : priorities) {
            priorityQueue.add(i);
        }

		while (!priorityQueue.isEmpty()) {

			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == priorityQueue.peek()) { //Priority Queue는 우선 순위를 먼저 결정하고 우선 순위가 높은 데이터가 가장 앞에 위치하기 때문에 이렇게 비교할 수 있다.
					priorityQueue.poll();
					answer ++;
					
					if (i == locations) {
						return answer;
					}
				}
			}
		} //while
		
		return answer;

	} // solution
} // Solution
