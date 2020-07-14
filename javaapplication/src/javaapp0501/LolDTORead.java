package javaapp0501;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LolDTORead {

	public static void main(String[] args) {
		// 인스턴스 단위로 기록한 파일 읽기
		try(ObjectInputStream ois = 
				new ObjectInputStream(
						new FileInputStream(
								"2020-05-01.dat"))){
			ArrayList<LolDTO> list = (ArrayList<LolDTO>)ois.readObject();
			for(LolDTO dto : list) {
				System.out.println(dto);
			}
		}catch(Exception e) {
			
		}

	}

}
