package study.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Week01_Array {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("입력(n, m, r): "); //지워야됨
			int n = reader.read();
			int m = reader.read();
			int r = reader.read();
			
			int[][] list = new int[n][m];
			
			for(int i = 0; i < r; i ++) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void suffixArray() { //11656번, 접미사 배열
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = reader.readLine();

			ArrayList<String> word = new ArrayList<String>();
			
			for(int i = 0; i < s.length(); i++) {
				String temp = s.substring(i);
				word.add(temp);
			}
			
			Collections.sort(word);
			
			for(String i : word) {
				System.out.println(i);
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //suffixArray 메서드
	
}
