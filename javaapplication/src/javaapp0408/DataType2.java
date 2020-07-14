package javaapp0408;

public class DataType2 {

	public static void main(String[] args) {
		int idx = 0;
		while(true) {
			//mod는 idx를 2로 나눈 나머지
			int mod = idx % 59;
			System.out.println(mod + 1 + "초");
			try {
				//1초대기
				Thread.sleep(1000);
			}catch(Exception e) {}
			
			idx++;
		}

	}

}
