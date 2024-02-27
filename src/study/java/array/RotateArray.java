package study.java.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//16926번, 배열 돌리기1
public class RotateArray {
	
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
		
		for (int i = 0; i < R; i++) { // 전체 회전 횟수

			for (int j = 0; j < count; j++) { //모든 라인 돌기
				int temp = arr[j][j]; //기준점

				//왼쪽으로 하나씩 이동
				for (int k = j + 1; k < M - j; k++) {
					arr[j][k - 1] = arr[j][k];
				}

				//위로 하나씩 이동
				for (int k = j + 1; k < N - j; k++) {
					arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
				}

				//오른쪽으로 하나씩 이동
				for (int k = M - 2 - j; k >= j; k--) {
					arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
				}
				

				//아래로 하나씩 이동
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
	} //main
} //RotateArray
