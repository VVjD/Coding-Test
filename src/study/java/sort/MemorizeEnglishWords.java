package study.java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			String[] words = new String [N];
			tokenizer = new StringTokenizer(reader.readLine());
			
			for (int i = 0; i < N; i++) { //담기				
				words[i] = tokenizer.nextToken();
			}
			
			for (int i = 0; i < words.length; i++) {
				int num = 1;
				
				for (int j = 0; j < words.length; j++) {

					if (map.containsKey(words[i])) {
						map.replace(words[i], num++);
						System.out.println(map.values());
					}
				}
			}
			
//			String[] words = new String [N];
//			tokenizer = new StringTokenizer(reader.readLine());
//			
//			for (int i = 0; i < N; i++) { //배열에 담기
//				words[i] = tokenizer.nextToken();
//			}
//			
//			Arrays.sort(words); //알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
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
