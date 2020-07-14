package javaapp0427;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		//스택 생성
		Stack <String> stack = new Stack<>();
		
		//스택에 데이터를 삽입
		stack.push("갱플랭크");
		//스택에서 데이터를 꺼내기
		String data = stack.pop();
		System.out.println(data);
		//Stack에 데이터가 없는데 꺼내려고 해서 예외가 발생
		data = stack.pop();

	}

}
