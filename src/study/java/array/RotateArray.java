package study.java.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//16926번, 배열 돌리기1
public class RotateArray {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("입력(n, m, r): "); // 지워야됨
			String answer = reader.readLine();
			String[] nums = answer.split(" ");

			int n = Integer.parseInt(nums[0]);
			int m = Integer.parseInt(nums[1]);
			int r = Integer.parseInt(nums[2]);
			int count = 0;

			int[][] a = new int[n][m];

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					a[i][j] = ++count;
					System.out.printf("%2d ", a[i][j]); // 지워야됨
				}
				System.out.println();
			}

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%2d ", a[i][j]);
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
