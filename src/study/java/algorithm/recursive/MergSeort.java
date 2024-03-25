package study.java.algorithm.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백준, 24060번 - 알고리즘 수업 - 병합 정렬 1
public class MergSeort {
	public static void main(String[] args) throws IOException {
		BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken()); //배열 A의 크기
		int K = Integer.parseInt(tokenizer.nextToken()); //저장 횟수
		
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		mergeSort(A, 0, N - 1); //처음 시작 0, 마지막 인덱스 N - 1
			
	}

	private static void mergeSort(int[] A, int p, int r) { //배열 A를 오름차순으로 정렬한다.
		if ( p < r) {
			int q = (p + r) / 2; //q는 p, r의 중간 지점
			mergeSort(A, p, q); //전반부 정렬
			mergeSort(A, q + 1, r); //후반부 정렬
			merge(A, p, q, r); //병합
		}
		
	}

	private static void merge(int[] a, int p, int q, int r) {
		
		int i = p;
		int j = q + 1;
		int k = r;
		
		
	}
}
