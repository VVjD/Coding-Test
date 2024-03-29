package study.java.algorithm.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백준, 24060번 - 알고리즘 수업 - 병합 정렬 1
//합병 정렬: 하나의 리스트를 두 개의 균등한 크기의 리스트로 분할하고 부분 리스트를 합치면서 정렬하여 최종적으로 전체가 정렬되게 하는 방법
public class MergSeort {
	static int[] A;
	static int[] temp;
	static int count = 0;
	static int K = 0; //저장 횟수
	static int result = -1; //저장 횟수가 K 보다 작으면 -1을 출력하기 때문에 -1로 초기화
	
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
		
		mergeSort(A, 0, N - 1); //처음 시작 0, 마지막 인덱스 N - 1
		
		builder.append(result);
		writer.append(builder.toString());
		
		writer.close();
		reader.close();	
	} // main
	
	

	
	/**
	 * @param A 배열
	 * @param p 시작
	 * @param r 마지막
	 */
	private static void mergeSort(int[] A, int p, int r) { //배열 A를 오름차순으로 정렬한다.
		if (p < r) { //배열의 길이가 0보다 큰 경우
			int q = (p + r) / 2; //q: p, r의 중간
			
			mergeSort(A, p, q); //전반부 정렬
			mergeSort(A, q + 1, r); //후반부 정렬
			merge(A, p, q, r); //병합       
		}
	} // mergeSort

	
	
	
	private static void merge(int[] A, int p, int q, int r) {
		
		int i = p; //p: 첫번째 배열의 시작
		int j = q + 1; //q: 중간 -> q + 1: 두번째 배열의 시작
		int t = 0;
		
		while(i <= q && j <= r) { //시작이 중간보다 작고, 그 다음 시작이 마지막보다 작은 경우 > 두 배열을 병합할 때 길이가 넘어가기 전까지 반복
			if(A[i] < A[j]) {
				temp[t++] = A[i++];
			} else {
				temp[t++] = A[j++];
			}
		}
		
		//남은 경우
		while(i <= q) { //왼쪽 배열이 남은 경우
			temp[t++] = A[i++];
		}
		
		while(j <= r) { //오른쪽 배열이 남은 경우
			temp[t++] = A[j++];
		}
		
		i = p; //정렬된 배열을 A에 저장하기 위해서 각각 초기화한다.
		t = 0;
		
		while(i <= r) { //결과를 배열 A에 저장
			count++;
			
			if (count == K) {
				result = temp[t];
				break;
			}
			
			A[i++] = temp[t++];
			
		}
	} //merge
	
	
	
	/*
	
	전반부 정렬
	4 5 1 3 2
	p = 0, r = 4
	q = 2

	mergeSort(A, 0, 2) -> 4 5 1
	p = 0, r = 2
	q = 1
	
	mergeSort(A, 0, 1) -> 4 5
	p = 0, r = 1
	q = 0
	
	mergeSort(A, 0, 0) -> 4
	p = 0, q = 0
	
	---
	후반부 정렬
	mergeSort(A, 1, 1) -> 5
	p = 1, r = 1
	merge(p = 0, q = 0, r = 1)
	i = 0, j = 1, t = 0 
	4, 5

	mergeSort(A, 2, 2) -> 1
	p = 2, r = 2
	merge(p = 0, q = 1, r = 2)
	i = 0, j = 2, t = 0
	1, 4, 5

	mergeSort(A, 3, 4) -> 3 2
	p = 3, r = 4
	q = 3	
	mergeSort(A, 3, 3) -> X
	mergeSort(A, 4, 4) -> X
	merge(p = 3, q = 3, r = 4)
	i = 3, j = 4, t = 0
	2, 3

	merge(p = 0, q = 2, r = 4)
	i= 0, j = 3, t = 0
	
*/
}
