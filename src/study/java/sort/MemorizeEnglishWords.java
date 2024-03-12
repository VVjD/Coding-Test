package study.java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MemorizeEnglishWords {
	// 백준 20920번
	public static void main(String[] args) {
		
		//자주 나오는 단어일수록 앞에 배치한다.
		//해당 단어의 길이가 길수록 앞에 배치한다.
		//알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
		//길이가 M이상인 단어들만 암기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		try {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());

			HashMap<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < N; i++) { // 담기
				String word = reader.readLine(); // 처음에는 배열에 담고 해당 배열을 확인하면서 반복 횟수를 계산했는데 그러면 코드가 복잡해지는 것 같다.

				if (word.length() >= M) { //길이가 M을 넘는 경우만
					if (map.containsKey(word)) { // 이미 해당 값이 키로 존재하면
						map.replace(word, map.get(word) + 1);
						System.out.println(map.entrySet());
					} else {
						map.put(word, 1);
					}
				}
			}
//			
//			for (int j = 0; j < map.size(); j++) {
//				map.
//			}
			
			//Collections.sort(map.keySet(), (o1, o2) -> map.get(o2).compareTo(map.get(o1)));

			System.out.println(map.values());
//			
//			
//			
//			for (int i = 0; i < words.length; i++) {
//				for (int j = 0; j < words.length; j++) {
//				}
//			}
//			
//			
//			
//			
//			while (tokenizer.hasMoreTokens()) { //Element() -> 문자열로 반환, Token() -> Object로 반환
//				
//				String temp = tokenizer.nextToken();
//				
//				
//				if (temp.length() >= M) { //길이 확인					
//					builder.append(temp);
//				}
//			}
			
		} catch (IOException e) {
			System.out.println("MemorizeEnglishWords.main");
			e.printStackTrace();
		}
	}
}
