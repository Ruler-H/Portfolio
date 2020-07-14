package javaapp0424;

import java.io.UnsupportedEncodingException;

public class StringEncoding {

	public static void main(String[] args) {
		// 한글을 저장한 문자열 인스턴스
		String hangul = "한글 문자열";

		// 바이트 배열로 변환
		try {
			byte [] bytes = hangul.getBytes("UTF-8");
			//바이트 배열을 문자열로 변환
			String str = new String(bytes, "EUCKR");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}