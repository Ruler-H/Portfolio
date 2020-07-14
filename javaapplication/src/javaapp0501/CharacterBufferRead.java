package javaapp0501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CharacterBufferRead {
	public static void main(String[] args) {
		// 현재 디렉토리에 있는 0406.txt 파일의 내용 읽기
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./0406.txt")))) {
			// 무한 반복해서 읽고
			while (true) {
				// 한 줄을 읽어서 읽은 줄이 null이면 종료 그렇지 않으면 계속 읽기
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}
		} catch (Exception e) {
		}
	}
}
