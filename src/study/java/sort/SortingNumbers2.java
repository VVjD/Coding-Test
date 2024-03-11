package study.java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortingNumbers2 {
	// 백준 2751번
	public static void main(String[] args) {
		
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
