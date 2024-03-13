package study.java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortingNumbers2 {
	// 백준 2751번
	public static void main(String[] args) {
		
		//ArraysSort();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		try {
			int N = Integer.parseInt(reader.readLine());
			boolean checkNum = true;

			Queue<Integer> tempQueue = new LinkedList<Integer>();
			//ArrayList<Integer> nums = new ArrayList<Integer>();
			int[] nums = new int[N];
			int count = 0;

			for (int i = 0; i < N; i++) {
				tempQueue.add(Integer.parseInt(reader.readLine()));
			}

			while (!tempQueue.isEmpty()) {

				for (int j = 0; j < tempQueue.size(); j++) {
					int top = tempQueue.poll();
					checkNum = true;

					for (int item : tempQueue) {

						if (item < top) {
							checkNum = false;

							break;
						}
					}

					if (checkNum) {
						nums[count] = top;
						count++;
					} else {
						tempQueue.add(top);
					}
				}
			}
			
			for (int k = 0; k < nums.length; k++) {
				builder.append(nums[k]).append("\n");
			}
			
			System.out.println(builder);

		} catch (IOException e) {
			System.out.println("SortingNumbers2.main");
			e.printStackTrace();
		}
			
	}

	private static void ArraysSort() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		try {	
			int N = Integer.parseInt(reader.readLine());
			
			int[] nums = new int [N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(reader.readLine());
			}
			
			Arrays.sort(nums);
			
			for (int j = 0; j < N; j++) {
				builder.append(nums[j]).append("\n");
			}
			
			System.out.println(builder);
			
		} catch (IOException e) {
			System.out.println("SortingNumbers2.main");
			e.printStackTrace();
		}
	}
}
