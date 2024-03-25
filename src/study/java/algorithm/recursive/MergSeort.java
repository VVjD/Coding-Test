package study.java.algorithm.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백준, 24060번 - 알고리즘 수업 - 병합 정렬 1
public class MergSeort {
	static int[] A;
	static int[] temp;
	static int count = 0;
	static int K = 0;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(tokenizer.nextToken()); //배열 A의 크기
		K = Integer.parseInt(tokenizer.nextToken()); //저장 횟수
		
		A = new int[N];
		temp = new int[N]; //정렬해서 저장할 배열
		
		tokenizer = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		mergeSort(A, 0, N - 1);
		
		builder.append(result); //처음 시작 0, 마지막 인덱스 N - 1
		writer.append(builder.toString());
		
		writer.close();
		reader.close();
			
	}

	private static void mergeSort(int[] A, int p, int r) { //배열 A를 오름차순으로 정렬한다.
		if ( p < r) {
			int q = (p + r) / 2; //q는 p, r의 중간 지점
			
			mergeSort(A, p, q); //전반부 정렬
			mergeSort(A, q + 1, r); //후반부 정렬
			merge(A, p, q, r); //병합
		}
		
	}

	private static void merge(int[] A, int p, int q, int r) {
		
		int i = p; //시작 인덱스
		int j = q + 1; //q: 중간
		int t = 0;
		
		while(i <= q && j <= r) { //시작이 중간보다 작고, 중간이 마지막보다 작은 경우
			if(A[i] < A[j]) {
				temp[t++] = A[i++];
			} else {
				temp[t++] = A[j++];
			}
		}
		
		//남은 경우
		while(i <= q) {
			temp[t++] = A[i++];
		}
		
		while(j <= r) {
			temp[t++] = A[j++];
		}
		
		i = p;
		t = 0;
		while(i <= r) {
			count++;
			
			if (count == K) {
				result = temp[t];
				break;
			}
			
			A[i++] = temp[t++];
		}
		
		
	}
}
