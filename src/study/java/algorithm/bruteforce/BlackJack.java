package study.java.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BlackJack {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			
			int N = Integer.parseInt(tokenizer.nextToken()); //카드의 개수
			int M = Integer.parseInt(tokenizer.nextToken()); //카드의 최대합
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for (int i = 0; i < N; i++) {
				map.put(i, Integer.parseInt(tokenizer.nextToken())); //배열보다 맵이 시간 복잡도 성능이 좋다.
			}
			
			
			
			
		} catch (IOException e) {
			System.out.print("Black.main");
			e.printStackTrace();
		}	
	} //main
}
