package chapter5.arraytest;

import java.util.Scanner;

public class ArrayTest6{

	public static void main(String[] args) {
		// 년과 월을 입력받아서 달력을 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.print("월을 입력하세요 : ");
		int month = sc.nextInt();
		int sum = 0;
		for(int i = 1; i < year; i = i + 1) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				sum = sum + 366;
			}else {
				sum = sum + 365;
			}
		}
		
		//올해 각 달의 날 수 배열 생성
		int [] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			months[2] = 29;
		}
		
		int week = sum % 7 - 1;
		int [][] calendar = new int[6][7];
		for(int i = week; i <= months[month] + week; i = i + 1) {
			calendar[i/6][i&7] = i - week;
		}
		
		//달력 출력
		System.out.println("월\t화\t수\t목\t금\t토\t일");
		for(int i = 0; i < 6; i = i + 1) {
			for(int j = 0; j < 7; j = j + 1) {
				if(calendar[i][j] != 0) {
					System.out.println(calendar[i][j] + "\t");
				}else {
					System.out.println(" ");
				}
			}
			System.out.print("\n");
		}
		
		
		
		/*for(int i = 1; i < month; i = i + 1) {
			switch(i) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				sum = sum + 31;
			case 2:
				if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
					sum = sum + 29;
				}else {
					sum = sum + 28;
				};
			case 4: case 6: case 9: case 11:
				sum = sum + 30;
				
			}
		}
		sum = sum + 1;
		if(sum % 7 == 0) {
			
		}
		*/
		
		sc.close();
	}

}
