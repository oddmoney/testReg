import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Learn001B92334 {
	/* 코딩테스트 연습
2022 KAKAO BLIND RECRUITMENT
신고 결과 받기
 */
	public static void main(String[] args) {
		//String id_list[] = {"muzi", "frodo", "apeach", "neo"};
		//String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","apeach frodo","apeach frodo","apeach muzi"};
		//solution(id_list, report, 2);
		
		String id_list[] = {"con", "ryan"};
		String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
		solution(id_list, report, 3);
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		
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
			
			tgtCntMap.put(tgts[1], (tgtCntMap.containsKey(tgts[1]) ? tgtCntMap.get(tgts[1]) : 0) + 1);
		});
		
		System.out.println("###tgtCntMap:::"+tgtCntMap.toString());
		System.out.println("###tgtArrMap:::"+tgtArrMap.toString());
		
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
		
		System.out.print("###tgtCntMap:::");
		for (int ii : answer) {
			System.out.print(" '" + ii + "' ");	
		}
		
		return answer;
	}

}
