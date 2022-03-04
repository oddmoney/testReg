import java.util.Scanner;

public class Main {
	/* 2884 / 알람 시계 */
	public static void main(String[] args) {
		// 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것이다.
		// 입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
		// 첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다. (입력과 같은 형태로 출력하면 된다.)
		Scanner sc = new Scanner(System.in);
		String[] hm = sc.nextLine().split("\\s");
		int h = Integer.parseInt(hm[0]);
		int m = Integer.parseInt(hm[1]);
		if (m >= 45) {
			System.out.println(hm[0] + " " + (m-45));
		} else {
			if (h > 0) {
				System.out.println((h-1) + " " + ((m+60)-45));
			} else {
				System.out.println("23 " + ((m+60)-45));
			}
		}
    }

	/* 14681 / 사분면 고르기 
	public static void main(String[] args) {
		// 아래 그림과 같이 사분면은 1부터 4까지 번호를 갖는다. "Quadrant n"은 "제n사분면"이라는 뜻이다.
		//               y
		//   Quardrant 2 | Quardrant 1
		//    B(-12, 5)  |  A(12, 5)
		// x ------------|------------
		//   Quardrant 3 | Quardrant 4
		//    C(-12, -5  |  D(12, -5)
		// 좌표가 (12, 5)인 점 A는 x좌표와 y좌표가 모두 양수이므로 제1사분면에 속한다. 점 B는 x좌표가 음수이고 y좌표가 양수이므로 제2사분면에 속한다.
		// 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오. 단, x좌표와 y좌표는 모두 양수나 음수라고 가정한다.
		Scanner sc = new Scanner(System.in);
		int pnt1 = sc.nextInt();
		int pnt2 = sc.nextInt();
		if (pnt1 > 0 && pnt2 > 0) System.out.println("1");
		else if (pnt1 < 0 && pnt2 > 0) System.out.println("2");
		else if (pnt1 < 0 && pnt2 < 0) System.out.println("3");
		else if (pnt1 > 0 && pnt2 < 0) System.out.println("4");
    }
	*/

	/* 2753 / 윤년 
	public static void main(String[] args) {
		// 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다
		int pnt = new Scanner(System.in).nextInt();
		if (pnt % 4 == 0 && (pnt % 100 != 0 || pnt % 400 == 0)) System.out.println("1");
		else System.out.println("0");
    }
    */
	
	/* 9498 / 시험 성적  
	public static void main(String[] args) {
		int pnt = new Scanner(System.in).nextInt();
		if (pnt >= 90 && pnt <= 100) System.out.println("A");
		else if (pnt >= 80 && pnt <= 89) System.out.println("B");
		else if (pnt >= 70 && pnt <= 79) System.out.println("C");
		else if (pnt >= 60 && pnt <= 69) System.out.println("D");
		else System.out.println("F");
    }
    */

	/* 1330 / 두 수 비교하기  
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		String arr[] = str.split("\\s");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		if (a > b) System.out.println(">");
		if (a < b) System.out.println("<");
		if (a == b) System.out.println("==");
    }
	 */

	/* 2588 / 곱셈  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		String b1 = sc.next();
		for(int i = b1.length(); i > 0; i--) {
			System.out.println(a1*Integer.parseInt(b1.substring(i-1, i)));
		}
		System.out.println(a1*Integer.parseInt(b1));
    }
    */

	/* 10430 / 나머지 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int c1 = sc.nextInt();
		System.out.println((a1+b1)%c1);
		System.out.println(((a1%c1) + (b1%c1))%c1);
		System.out.println((a1*b1)%c1);
		System.out.println(((a1%c1) * (b1%c1))%c1);
    }
    */

	/* 18108 / 1998년생인 내가 태국에서는 2541년생?!  
	public static void main(String[] args) {
		int id = new Scanner(System.in).nextInt();
		System.out.println(id - 543);
    }
    */

	/* 10926 / ??! 
	public static void main(String[] args) {
		String id = new Scanner(System.in).next();
		System.out.println(id + "??!");
    }
    */

	/* 10869 / 사칙연산 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.println(a1+a2);
		System.out.println(a1-a2);
		System.out.println(a1*a2);
		System.out.println(a1/a2);
		System.out.println(a1%a2);
    }
    */

	/* 1008 / A/B
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a1 = Double.valueOf(sc.nextInt());
		double a2 = Double.valueOf(sc.nextInt());
		System.out.println(a1/a2);
    }
    */

	/* 10998 / A*B 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.println(a1*a2);
    }
	*/

	/* 1001 / A-B 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.println(a1-a2);
    }
	*/

	/* 1000 / A+B
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.println(a1+a2);
    }
    */

	/* 10172 / 개 
	public static void main(String[] args) {
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
    }
    */
	
	/* 10171 / 고양이 
	public static void main(String[] args) {
    	System.out.println("\\    /\\");
    	System.out.println(" )  ( ')");
    	System.out.println("(  /  )");
    	System.out.println(" \\(__)|");
    }
    */
	
	/* 10718 / We love kriii
	public static void main(String[] args) {
    	System.out.println("강한친구 대한육군");
    	System.out.println("강한친구 대한육군");
    }
	/* 2557 / Hello World
    public static void main(String[] args) {
        System.out.print("Hello World!");
    }
    */
}
