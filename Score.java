package javaFund;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] subject = {"국어", "영어", "수학"};
		int[] score = new int[4];
		double[] avg = new double[1];
		
		char grade;
		
		for (int i = 0; i < 3; i++) {
            do {
                System.out.print(subject[i] + " 점수를 입력하세요 : ");
                score[i] = sc.nextInt();

//                if (score[i] < 0 || score[i] > 100) {
//                    System.out.println(subject[i] + " 점수를 입력하세요 : ");
//                }

            } while (score[i] < 0 || score[i] > 100);

            score[3] += score[i];
        }
		
		avg[0] = score[3] / 3.0;
		
		switch((int) avg[0] / 10) {
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
		System.out.println("총점 : " + score[3]);
		System.out.printf("평균 : %.2f\n", avg[0]);
		System.out.println("학점 : " + grade);
		
		sc.close();
		
	}

}
