package programmers.lessons_92334;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
		
		HashMap<String, Integer> tgtCntMap = new HashMap<>();
		HashMap<String, List<String>> tgtArrMap = new HashMap<>();
		
		Stream.of(report).distinct().forEach(str -> {
			String tgts[] = str.split(" ");
			if (tgtArrMap.containsKey(tgts[0])) {
				if (!tgtArrMap.get(tgts[0]).contains(tgts[1])) {
					tgtArrMap.get(tgts[0]).add(tgts[1]);
				}
			} else {
				List<String> arrs = new ArrayList<>();
				arrs.add(tgts[1]);
				tgtArrMap.put(tgts[0], arrs);
			}
			
			tgtCntMap.put(tgts[1], (tgtCntMap.containsKey(tgts[1]) 
					? tgtCntMap.get(tgts[1]) : 0) + 1);
		});
		
		int[] answer = new int[id_list.length];
		for (int i=0;i<id_list.length;i++) {
			int idCnt = 0;

			if (tgtArrMap.containsKey(id_list[i])) {
				for (String u : tgtArrMap.get(id_list[i])) {
					if (tgtCntMap.get(u) >= k) idCnt++;
				}
			}
			
			answer[i] = idCnt;
		}
		
		return answer;
    }
}