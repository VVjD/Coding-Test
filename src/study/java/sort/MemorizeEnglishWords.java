package study.java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MemorizeEnglishWords {
	// 백준 20920번
	public static void main(String[] args) {
		
		//길이가 M이상인 단어들만 암기
		//자주 나오는 단어일수록 앞에 배치한다.
		//해당 단어의 길이가 길수록 앞에 배치한다.
		//알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		try {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());

			HashMap<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				String word = reader.readLine(); // 처음에는 배열에 담고 해당 배열을 확인하면서 반복 횟수를 계산했는데 그러면 코드가 복잡해지는 것 같다.

				if (word.length() >= M) { //길이가 M을 넘는 경우만
					
					if (map.containsKey(word)) { // 이미 해당 값이 키로 존재하면
						map.replace(word, map.get(word) + 1);
						
					} else {
						map.put(word, 1);
					}
				}
			}
			
			List<String> keys = new ArrayList<String>(map.keySet()); //값을 기준으로 정렬하기 위해서 리스트에 담기
			
			//Collections.sort(keys, (o1, o2) -> (map.get(o2).compareTo(map.get(o1)))); //내림차순 정렬			
			//앞이 작으면 음수, 뒤가 작으면 양수, 값이 같으면 0을 반환
			Collections.sort(keys, (o1, o2) -> {
			    Integer value1 = map.get(o1);
			    Integer value2 = map.get(o2);
			    
			    // 값이 같을 때
			    if (value1.equals(value2)) {
			        // 길이를 기준으로 정렬
			        int lengthCompare = Integer.compare(o2.length(), o1.length()); // 내림차순
			        
			        // 길이가 같은 경우에는 알파벳 기준으로 정렬
			        if (lengthCompare == 0) { //값이 같은 경우
			            return o1.compareTo(o2);
			            
			        } else {
			            return lengthCompare;
			        }
			    } else {
			        // 값이 다르면 횟수를 기준으로 정렬
			        return value2.compareTo(value1); // 내림차순
			    }
			});
			
			for (String key : keys) {
				builder.append(key).append("\n");
			}
		
			System.out.println(builder);	
			
		} catch (IOException e) {
			System.out.println("MemorizeEnglishWords.main");
			e.printStackTrace();
		}
	}
}
