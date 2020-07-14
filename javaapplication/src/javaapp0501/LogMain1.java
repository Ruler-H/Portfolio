package javaapp0501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.HashSet;
import java.util.TreeSet;

public class LogMain1 {

	public static void main(String[] args) {
		try(BufferedReader ar = 
				new BufferedReader(
						new InputStreamReader(
								new FileInputStream(
										"C:\\Users\\30401\\Desktop\\log.txt")))){
			//IP를 중복없이 저장하기 위한 Set을 생성
			TreeSet<String> set = new TreeSet<>();
			//파일 전체 내용을 줄 단위로 읽기
			int sum = 0;
			while(true) {
				//한 줄 읽어서 line에 저장
				String msg = ar.readLine();
				//읽은 내용이 없으면 중단
				if(msg == null) {
					break;
				}
				
				//읽은 데이터가 있으면 출력
				//System.out.println(msg);
				//공백을 기준으로 문자열 분할
				String [] data = msg.split(" ");
				//분할된 데이터 중에서 첫번째 데이터만 출력
				//System.out.println(data[0]);
				set.add(data[0]);
				/*
				for(String ip : set) {
					System.out.println(ip);
				}
				*/
				try {
				sum = sum + Integer.parseInt(data[9]);
				}catch(Exception e) {}
			}
			System.out.println("트래픽 합계 : " + sum);
		}catch(Exception e) {
			
		}
	}

}
