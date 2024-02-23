package study.java.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//11656번, 접미사 배열
public class SuffixArray {
	
	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s = reader.readLine();
			ArrayList<String> word = new ArrayList<String>(); 

			for (int i = 0; i < s.length(); i++) {
				String temp = s.substring(i);
				
				word.add(temp); // 잘라서 담기
			}

			Collections.sort(word); // 정렬

			for (String i : word) { // 출력
				System.out.println(i);
			}

			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}  // SuffixArray
