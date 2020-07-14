package javaapp0501;

import java.io.PrintWriter;

public class CharacterBufferWrite {

	public static void main(String[] args) {
		try (PrintWriter pw = 
				new PrintWriter(
						"C:\\Users\\30401\\Desktop\\"
						+ "JavaApplication\\javaapp0501\\pw.txt")){
			pw.println("문자 단위로 버퍼를 이용해서 기록");
			pw.flush();
			
		}catch(Exception e) {
			//예외 내용을 출력
			System.out.println(e.getMessage());
			//예외 발생 지점을 역추적
			e.printStackTrace();
		}

	}

}
