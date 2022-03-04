package programmers.lessons_77484;

public class Main {
	/* 코딩테스트 연습
2022 KAKAO BLIND RECRUITMENT
신고 결과 받기
 */
	public static void main(String[] args) {
//		int lottos[] = {44, 1, 0, 0, 31, 25};
//		int win_nums[] = {31, 10, 45, 1, 6, 19};

//		int lottos[] = {0,0,0,0,0,0};
//		int win_nums[] = {38, 19, 20, 40, 15, 25};

		int lottos[] = {45, 4, 35, 20, 3, 9};
		int win_nums[] = {20, 9, 3, 45, 4, 35};

		int[] result = new Solution().solution(lottos, win_nums);
		System.out.print("###result:::");
		for (int ii : result) {
			System.out.print(" '" + ii + "' ");	
		}
	}

}
