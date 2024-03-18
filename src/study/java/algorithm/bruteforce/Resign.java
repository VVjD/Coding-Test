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
        int[] dp = new int[N + 1]; //각 날짜까지의 최대 이익을 저장 > 0부터 시작하기 때문에 1을 저장해서 N까지 값으로 가질 수 있게 설정

        for (int i = 0; i < N; i++) {
            int endDate = i + list.get(i).getPeriod(); // 상담 종료일
            
            if (endDate <= N) { // 상담 종료일이 퇴사 전인 경우
                dp[endDate] = Math.max(dp[endDate], dp[i] + list.get(i).getMoney()); 
                //Returns the greater of two int values. That is, theresult is the argument closer to the value of Integer.MAX_VALUE. If the arguments have the same value,the result is that same value.
                //dp[i] + list.get(i).getMoney(): 이전까지의 최대 이익에 현재 상담을 진행했을 때의 이익을 더한 값
                //dp[endDate]: 현재 상담 종료일까지의 최대 이익
                //endDate가 동일한 경우 이전의 최대 이익 값과 현재 상담을 진행했을 때의 이익 값을 비교하여 최대 이익을 저장한다.
            }
            
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); 
            // dp[i + 1] = Math.max(dp[i + 1], dp[i]);: 다음 날짜의 최대 이익을 갱신한다. 현재까지의 최대 이익(dp[i])과 다음 날짜의 최대 이익(dp[i + 1]) 중 큰 값을 선택하여 저장한다.
            //예를 들어 i가 4인 경우 4일에 종료되는 상담과 5일에 종료되는 상담의 이익을 비교하는데, 만약 5일에 종료되는 상담이 존재하지 않는 경우 해당 날짜의 최대 이익은 이전 날과 동일하기 때문이다.
        }

        return dp[N]; //퇴사 날짜(N)까지의 최대 이익을 반환한다.
    }
} //Resign

	/*
 
 		i = 0
 		endDate = 0 + 3 = 3
 		dp[3] = Math.max(0, dp[2] + 10) = 10
 		dp[1] = Math.max(dp[1], dp[0]) = 0
 		
 		i = 1
 		endDtae = 1 + 5 = 6
 		dp[6] = Math.max(dp[6], dp[1] + 20) = 20 //2일 상담을 하는 경우 1일 상담은 할 수 없음 > 얘는 2일에 시작하는 거라 1일에 종료하는 상담의 금액에 이 강의를 진행하였을 때의 금액을 더한 값과 이전에 존재하는 상담 종료일이 일치하는 값과 비교하는 것이다.
 		dp[2] = Math.max(dp[2], dp[1]) = 0
 		
 		i = 2
 		endDate = 2 + 1 = 3
 		dp[3] = Math.max(10, dp[2] + 10) = 10 //3일 상담을 하는 경우 1일과 2일 상담은 할 수 없음
 		dp[3] = Math.max(dp[3], dp[2]) = 10 
 		
 		i = 3
 		endDate = 3 + 1 = 4
 		dp[4] = Math.max(dp[4], dp[3] + 20) = 30
 		dp[4] = Math.max(dp[4], dp[3]) = 30
 		
 		i = 4
 		endDate = 4 + 2 = 6
 		dp[6] = Math.max(dp[6], dp[4] + 15) = 45
 		dp[5] = Math.max(dp[5], dp[4]) = 30 //여기서보면 5일에 종료되는 과정이 없어서 5일에 최대 금액은 4일과 동일하게 처리한다.
 		
 		i = 5
 		endDate = 5 + 4 = 9
 		dp[6] = Math.max(dp[6], dp[5]) = 45
 		
 		i = 6
 		endDate = 6 + 2 = 8
 		dp[7] = Math.max(dp[7], dp[6]) = 45
 
	 */



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
