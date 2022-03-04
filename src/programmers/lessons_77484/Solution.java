package programmers.lessons_77484;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        
        List<int[]> list = new ArrayList<>(); 
        for (int n : lottos) {
    		int[] tmp = {n, -1};
    		for (int w : win_nums) if (n == w) tmp[1] = w;
    		list.add(tmp);
        }

        int rankHigh = 0;
        int rankLow = 0;
        for (int[] ns : list) {
        	if (0 == ns[0]) {
        		rankHigh++;
        	} else if (ns[0] == ns[1]) {
        		rankHigh++;
        		rankLow++;
        	}
        }
        answer[0] = getRank(rankHigh);
        answer[1] = getRank(rankLow);

        return answer;
    }
    
	private int getRank(int r) {
		if (r==6) return 1;
		if (r==5) return 2;
		if (r==4) return 3;
		if (r==3) return 4;
		if (r==2) return 5;
		return 6;
    }

}