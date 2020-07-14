package javaapp0501;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableMain {

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\30401\\Documents\\oo.dat"))) {
			// DTO 클래스의 인스턴스를 생성
			DTO dto = new DTO("a01", "갱플랭크", 1.00);
			// 파일에 기록
			oos.writeObject(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:\\Users\\30401\\Documents\\oo.dat"))) {
			DTO dto = (DTO) ois.readObject();
			System.out.println(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
