package study.java.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Resign {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        StringBuilder builder = new StringBuilder();
        List<Table> list = new ArrayList<>();

        try {
            int N = Integer.parseInt(reader.readLine()); // 오늘부터 N+1일째 되는 날 퇴사
            int result = 0; // 총 이익

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                
                int period = Integer.parseInt(tokenizer.nextToken());
                int money = Integer.parseInt(tokenizer.nextToken()); 
                Table table = new Table(period, money);
                
                list.add(table);
            }

            result = getMaxProfit(N, list);
            
            builder.append(result).append("\n");

            writer.write(builder.toString());
            writer.flush();

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main

    
    
    private static int getMaxProfit(int N, List<Table> list) {
        int[] dp = new int[N + 1]; //각 날짜까지의 최대 이익을 저장

        for (int i = 0; i < N; i++) {
            int endDate = i + list.get(i).getPeriod(); // 상담 종료일
            
            if (endDate <= N) { // 상담 종료일이 퇴사 전인 경우
                dp[endDate] = Math.max(dp[endDate], dp[i] + list.get(i).getMoney()); //Returns the greater of two int values. That is, theresult is the argument closer to the value of Integer.MAX_VALUE. If the arguments have the same value,the result is that same value.
                //dp[i] + list.get(i).getMoney(): 현재 상담을 진행했을 때의 새로운 이익입니다. 이전까지의 최대 이익(dp[i])에 현재 상담을 진행했을 때의 이익을 더한 값입니다.
                //dp[endDate]: 현재 상담 종료일(endDate)까지의 최대 이익을 나타냅니다. 이 값은 이미 이전에 계산된 값 중에서 가장 큰 이익을 나타내고 있습니다. 따라서, 현재 상담을 진행하면서 얻을 수 있는 새로운 이익과 기존의 최대 이익 중 큰 값을 선택하여 dp[endDate]에 저장합니다.
            }
            
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // dp[i + 1] = Math.max(dp[i + 1], dp[i]);: 다음 날짜의 최대 이익을 갱신합니다. 현재까지의 최대 이익(dp[i])과 다음 날짜의 최대 이익(dp[i + 1]) 중 큰 값을 선택하여 dp[i + 1]에 저장합니다. 이는 이전까지의 최대 이익을 현재까지의 최대 이익으로 가져오는 과정입니다.
        }

        return dp[N]; //퇴사 날짜(N)까지의 최대 이익을 반환합니다. 이는 dp 배열의 마지막 요소에 해당한다.
    }
}



class Table {
    private int period;
    private int money;

    public Table(int period, int money) {
        this.period = period;
        this.money = money;
    }

    public int getPeriod() {
        return period;
    }

    public int getMoney() {
        return money;
    }
}

/*
public class Resign {
	public static void main (String[] agrs) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer;
		StringBuilder builder = new StringBuilder();
		List<Table> list = new ArrayList<Table>();
		
		try {
			int N = Integer.parseInt(reader.readLine()); //오늘부터 N+1일째 되는 날 퇴사
			int prevEndDate = 0; //이전 상담 종료일
			int result = 0; //총 이익
			
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				
				Table table = new Table(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), i);
				
				list.add(table);
			}
			
			list = list.stream().sorted((s1, s2) -> { //종료일 기준으로 정렬
				if (s1.getEndDate() == s2.getEndDate()) { //둘의 종료일이 일치하면
					return s1.getStartDate() - s2.getStartDate(); //더 빨리 시작하는 것
				} else {
					return s1.getEndDate() - s2.getEndDate();
				}
			}).collect(Collectors.toList());
			
			for (int j = 0; j < list.size(); j++) {
//				System.out.println("StartDate: " + list.get(j).getStartDate());
//				System.out.println("prevEndDate: " + prevEndDate);
//				System.out.println("EndDate: "+list.get(j).getEndDate());
//				System.out.println();
				
				if (prevEndDate < list.get(j).getStartDate() && list.get(j).getEndDate() < N) { //이전 상담이 종료되고 시작하며, 모든 일정 종료일이 퇴사일 전인 경우
					prevEndDate = list.get(j).getEndDate();
					result += list.get(j).getMoney();
//					System.out.println("result: "+result);
//					System.out.println();
				}
			}
			
			for (int j = 0; j < list.size(); j++) {
			    if (prevEndDate <= list.get(j).getStartDate() && list.get(j).getEndDate() <= N) {
			        prevEndDate = list.get(j).getEndDate();
			        result = Math.max(result, result + list.get(j).getMoney());
			    }
			}

			
			builder.append("*"+result).append("\n");
			
			writer.write(builder.toString());
			writer.flush();
			
			reader.close();
			writer.close();
			
		} catch (IOException e) {
			System.out.println("Resign.main");
			e.printStackTrace();
		}
		
	} //main
}



class Table {
	private int period;
	private int money;
	private int num;
	
	public Table(int period, int money, int num) {
		this.period = period;
		this.money = money;
		this.num = num;
	}
	
	public int getPeriod() {
		return period;
	}
	public int getMoney() {
		return money;
	}
	
	public int getStartDate() {
		return num + 1;
	}

	public int getEndDate() {
		return num + period;
	}

	@Override
	public String toString() {
		return "Table [period=" + period + ", money=" + money + ", StartDate=" + getStartDate() + ", EndDate=" + getEndDate() + "]";
	}
}
*/
