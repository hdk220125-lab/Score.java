package javaFund;

import java.util.Scanner;

public class Score2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] subject = {"국어", "영어", "수학"};
		
		int[][] score = new int[3][3]; //[학생][과목]
		int[] sum = new int[3];
		double[] avg = new double[3];
		
		char grade;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("\n" + (i + 1) + "번 학생 점수 입력");
			for (int j = 0; j < 3; j++) {
				 do {
		                System.out.print(subject[j] + " 점수를 입력하세요 : ");
		                score[i][j] = sc.nextInt();

//		                if (score[i] < 0 || score[i] > 100) {
//		                    System.out.println(subject[i] + " 점수를 입력하세요 : ");
//		                }

		            } while (score[i][j] < 0 || score[i][j] > 100);
				 
				 sum[i] += score[i][j];
			}
      
			avg[i] = sum[i] / 3.0;
        }
		
		for(int i = 0; i < 3; i++) {
			
			switch((int) avg[i] / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			default :
				grade = 'F';
			}
			
			System.out.println("\n========== 성적 결과 ==========");
			System.out.println(i + 1 + "번 학생 총점 : " + sum[i]);
			System.out.printf(i + 1 + "번 학생 평균 : %.2f\n", avg[i]);
			System.out.println("학점 : " + grade);
		}
		
		sc.close();
	}

}
