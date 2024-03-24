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
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokenizer.nextToken());
		}
			
	}
}
