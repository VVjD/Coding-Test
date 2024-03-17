package study.java.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BlackJack {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();

		try {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

			int N = Integer.parseInt(tokenizer.nextToken()); // 카드의 개수
			int M = Integer.parseInt(tokenizer.nextToken()); // 카드의 최대합

			ArrayList<Integer> list = new ArrayList<Integer>();
			tokenizer = new StringTokenizer(reader.readLine());

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(tokenizer.nextToken())); // 삽입과 삭제가 빈번한 경우에는 LinkedList가 효율적일 수 있지만, 읽기가 빈번한 경우에는 Array 또는 ArrayList가 더 효율적
			}

			builder.append(blackJack(M, list));

			writer.write(builder.toString());
			writer.flush(); // 버퍼 비우기 > 안 적었더니 출력 안 됨

			reader.close();
			writer.close();

		} catch (IOException e) {
			System.out.print("Black.main");
			e.printStackTrace();
		}
	} // main

	
	
	private static int blackJack(int M, ArrayList<Integer> list) {
		int sum = 0;
		int temp = 0;

		// N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력
		for (int i = 0; i < list.size() - 2; i++) {

			for (int j = i + 1; j < list.size() - 1; j++) {

				for (int k = j + 1; k < list.size(); k++) {

					sum = list.get(i) + list.get(j) + list.get(k);

					if (sum <= M && sum > temp) { // 최대 합보다 작고 temp보다 큰지 확인
						temp = sum;
					}
				}
			}
		} // for

		return temp;
	}
}
