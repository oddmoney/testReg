package programmers.lessons_92334;

public class Main {
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


		int[] result = new Solution().solution(id_list, report, 0);
		System.out.print("###result:::");
		for (int ii : result) {
			System.out.print(" '" + ii + "' ");	
		}
	}

}
