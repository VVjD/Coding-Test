package study.java.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//16926번, 배열 돌리기1
public class RotateArray {

//	public static void main(String[] args) {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//		try {
//			System.out.print("입력(n, m, r): "); // 지워야됨
//
//			String answer = reader.readLine();
//			String[] nums = answer.split(" "); // space를 기준으로 나눠서 담기
//			int n = Integer.parseInt(nums[0]);
//			int m = Integer.parseInt(nums[1]);
//			int r = Integer.parseInt(nums[2]);
//			int count = 0;
//			int[][] a = new int[n][m];
//
//			for (int i = 0; i < a.length; i++) {
//				for (int j = 0; j < a[0].length; j++) {
//					a[i][j] = ++count;
//
//					System.out.printf("%2d ", a[i][j]); // 지워야됨
//				}
//				System.out.println();
//			}
//
//			for (int i = 0; i < a.length; i++) {
//				for (int j = 0; j < a[0].length; j++) {
//					System.out.printf("%2d ", a[i][j]); // 지워야 됨
//				}
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		int[][] map = new int[N][M]; // 배열 입력 받기
//		
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			for(int j=0; j<M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//        // R번 수행
//		for(int i=0; i<R; i++) {
//        	// 가장 큰 사각형부터 안으로 한 번씩 돌리기
//			for(int j=0; j< Math.min(N, M)/2; j++) {
//				int temp = map[j][j];  //각 사각형의 왼쪽 위 값 저장
//
//				// left
//				for(int k=j; k<M-j-1; k++) {
//					map[j][k] = map[j][k+1];
//				}
//				
//				// up
//				for(int k=j; k<N-1-j; k++) {
//					map[k][M-j-1] = map[k+1][M-j-1];
//				}
//				
//				// right
//				for(int k=M-j-1; k>j; k--) {
//					map[N-1-j][k] = map[N-1-j][k-1];
//				}
//				
//				// down
//				for(int k=N-j-1; k>j; k--) {
//					map[k][j] = map[k-1][j];
//				}
//				
//				map[j+1][j] = temp;
//			}
//			
//		}
//		
//		for(int i=0; i<N; i++) {
//			
//			for(int j=0; j<M; j++) {
//				sb.append(map[i][j]).append(" ");
//			}
//			
//			sb.append("\n");
//		}
//		
//		System.out.println(sb);
//	} //main
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // Java에서 문자열을 구분자(delimiter)를 기준으로 토큰(token)으로 분리하는 데 사용되는 클래스 > 여기서는 한 줄식 입력받아서 공백을 기준으로 분리한다.
		int N = Integer.parseInt(tokenizer.nextToken()); //열
		int M = Integer.parseInt(tokenizer.nextToken()); //행
		int R = Integer.parseInt(tokenizer.nextToken()); //회전 수
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine()); //공백을 기준으로 분리
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken()); //int로 바꿔서 배열에 담기
			}
		}

		int count = Math.min(N, M) / 2; //회전 될 라인 수
		
		for (int i = 0; i < R; i++) { // 회전 횟수

			for (int j = 0; j < count; j++) { //모든 라인 돌리기
				int temp = arr[j][j]; //기준점

				//오른쪽으로 하나씩 이동
				for (int k = j + 1; k < M - j; k++) {
					arr[j][k - 1] = arr[j][k];
				}

				//아래로
				for (int k = j + 1; k < N - j; k++) {
					arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
				}

				//위로
				for (int k = M - 2 - j; k >= j; k--) {
					arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
				}

				//아래로
				for (int k = N - 2 - j; k >= j; k--) {
					arr[k + 1][j] = arr[k][j];
				}

				arr[j + 1][j] = temp;
			}
		}

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}
}
