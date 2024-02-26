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
			String[] nums = answer.split(" "); // space를 기준으로 나눠서 담기
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
					System.out.printf("%2d ", a[i][j]); // 지워야 됨
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		
//        // 배열 입력 받기
//		int[][] map = new int[N][M];
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//        // R번 수행
//		for(int i=0; i<R; i++) {
//        	// 가장 큰 사각형부터 안으로 한 번씩 돌리기
//			for(int j=0; j< Math.min(N, M)/2; j++) {
//				
//				int temp = map[j][j];  //각 사각형의 왼쪽 위 값 저장
//				
//				// left
//				for(int k=j; k<M-j-1; k++) {
//					map[j][k] = map[j][k+1];
//				}
//				// up
//				for(int k=j; k<N-1-j; k++) {
//					map[k][M-j-1] = map[k+1][M-j-1];
//				}
//				// right
//				for(int k=M-j-1; k>j; k--) {
//					map[N-1-j][k] = map[N-1-j][k-1];
//				}
//				// down
//				for(int k=N-j-1; k>j; k--) {
//					map[k][j] = map[k-1][j];
//				}
//				map[j+1][j] = temp;
//			}
//		}
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				sb.append(map[i][j]).append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
//	}
}
